package edu.curtin.saed.assignment1;

import edu.curtin.saed.assignment1.model.Citadel;
import edu.curtin.saed.assignment1.model.Robot;
import edu.curtin.saed.assignment1.model.Wall;

import java.util.*;
import java.util.concurrent.*;

public class RobotLogic
{
    private final ScheduledExecutorService executor;
    private final ScheduledExecutorService movementExecutor;

    private final BlockingQueue<Runnable> blockqueue1;
    private final Random random;
    private final JFXArena arena;
    private int gridX=0, gridY=0;

    double citadelX = 0;
    double citadelY = 0;

    private final int minDelay = 500;
    private final int maxDelay = 2000;
    boolean flag = false;
    private final int maxNoOfRobots = 4;
    public int currentNoOfRobots = 0;

    private ArrayList<Integer> randNumberList = new ArrayList<>();


    public RobotLogic(JFXArena jfxArena, int gridX, int gridY)
    {
        this.executor = Executors.newScheduledThreadPool(1);
        this.blockqueue1 = new LinkedBlockingQueue<>();
        this.random = new Random();
        this.arena = jfxArena;
        this.gridX = gridX;
        this.gridY = gridY;
        movementExecutor = Executors.newScheduledThreadPool(1);
    }

    public void callToBuildRobots() {
        Runnable buildRobotTask = new Runnable() {
            @Override
            public void run()
            {
                buildRobots();
//                startRobotMovementBackgroundThread();
            }

        };

        executor.scheduleAtFixedRate(buildRobotTask, 0, 1500, TimeUnit.MILLISECONDS);
    }



    private int returnRandomNumber(int number)
    {
        //run once.
        genRandomOptionsOnce(number);

        int randomNumber = -1;

        while(!randNumberList.isEmpty())
        {
            Collections.shuffle(randNumberList);
            randomNumber = randNumberList.remove(0);
//            System.out.println("Randomly picked return Value: "+ randomNumber);
            return randomNumber;
        }
        return randomNumber;
    }

    private boolean genRandomOptionsOnce(int number)
    {
        if(flag == false)
        {
            generateRandomOptions(number);
            flag = true;
        }
        return flag;
    }

    //add 0,1,2,3 to an array List for the generateRobot() case statement.
    //generates random numbers less that the input param.
    private void generateRandomOptions(int number)
    {
        for(int i=0;i<number;i++)
        {
            randNumberList.add(i);
        }
    }

    private void buildRobots()
    {
        if (!blockqueue1.isEmpty())
        {
            return; // Don't generate a new robot if there's already a task in the queue
        }
            int delay = random.nextInt(maxDelay-minDelay) + minDelay;
            int corners = returnRandomNumber(4);

        if(!checkRobotPresent() == true)
        {
            blockqueue1.offer(() ->
            {
                //0,1,2,3 corners

                double robotX = -1;
                double robotY = -1;

                if(corners ==  0){

                    robotX = 0;
                    robotY = 0;
                }
                else if(corners == 1)
                {
                    robotX = gridX-1;
                    robotY = 0;

                }
                else if(corners == 2 )
                {
                    robotX = 0;
                    robotY = gridY-1;
                }
                else if(corners == 3)
                {
                    robotX = gridX-1;
                    robotY = gridY-1;
                }

                Robot robot = new Robot(robotX, robotY, delay);

                arena.addRobot(robot);
                movementExecutor.scheduleAtFixedRate(() -> moveRobotRandomly(robot),  0, delay, TimeUnit.MILLISECONDS);

            });
        }
        executor.execute(blockqueue1.poll());
    }



    private boolean checkRobotPresent()
    {
        boolean flag = false;

        // Check if a robot is present in all four corners
        if (checkTopLeft() && checkTopRight() && checkBottomLeft() && checkBottomRight()) {
            flag = true;
            System.out.println("Robots present in all four corners.");
            stopBuildingRobots();
        }
        return flag;
    }

    private boolean checkTopLeft()
    {
        boolean flag = false;
        boolean topLeft = arena.isRobotPresent(0, 0);

        if(topLeft == true)
        {
            flag = true;
        }
        return flag;
    }

    private boolean checkTopRight()
    {
        boolean flag = false;
        boolean topRight = arena.isRobotPresent(gridX-1, 0);

        if(topRight == true)
        {
            flag = true;
        }
        return flag;
    }

    private boolean checkBottomLeft()
    {
        boolean flag = false;
        boolean bottomLeft = arena.isRobotPresent(0, gridY-1);

        if(bottomLeft == true)
        {
            flag = true;
        }
        return flag;
    }

    private boolean checkBottomRight()
    {
        boolean flag = false;
        boolean bottomRight = arena.isRobotPresent(gridX-1, gridY-1);

        if(bottomRight == true)
        {
            flag = true;
        }
        return flag;
    }

    private void moveRobotRandomly(Robot robot)
    {
            double curX;
            double curY;
            //up, down, left, right
            int[][] potentialSteps = { {-1, 0}, {1, 0}, {0, -1}, {0, 1} };
            int index = random.nextInt(4);

            curX = robot.getX();
            curY = robot.getY();

            int newCurX = (int) curX + potentialSteps[index][0];
            int newCurY = (int) curY + potentialSteps[index][1];

            // is the x and y position is acceptable?
            if (acceptableMove(newCurX, newCurY)) {
                // Update the robot's position
                robot.setX(newCurX);
                robot.setY(newCurY);
//            arena.addRobot(robot);
            }

            //return true if wall has been hit
            if(hitWall(curX, curY))
            {
                arena.removeRobot(robot);
                arena.newEventInstance("Wall Hit!");
                currentNoOfRobots = currentNoOfRobots - 1;
                arena.wallHit();
            }

            //return true is broken wall has been hit
            if(hitBrokenWall(curX, curY))
            {
                arena.removeRobot(robot);
                currentNoOfRobots = currentNoOfRobots - 1;
                arena.brokenWallHit();
            }

            if(isEndGame(newCurX, newCurY) || arena.getRobots().size() == 0)
            {
                arena.endTheGame(true);
                stopMovingRobots();
            }


    }

    public boolean acceptableMove(int x, int y)
    {

        boolean boundCheck, notVacant = true;

        //grid boundaries
        boundCheck = x < gridX && x >= 0  && y < gridY && y >= 0;

        // We will see if another robot is found in the next location the robots move to.
        for(Robot robot : arena.getRobots())
        {
            if(robot.getX() == x && robot.getY() == y)
            {
                notVacant = false;
                break;
            }
        }
        return boundCheck && notVacant;
    }

    public boolean isEndGame(int x, int y)
    {
        boolean gameOver = false;

        getCidetalLocation();
        boolean endTheGame = x == citadelX && y == citadelY;

        if(arena.robots.size() == 0)
        {
            gameOver = true;
        }
//        System.out.println("Citadel location is : " + citadelX + " " + citadelY);
        return endTheGame || gameOver;
    }


    private void getCidetalLocation()
    {

        if(arena.getCitadels().isEmpty())
        {
            System.out.println("Add the Citadel");
        }else
        {
            for(Citadel citadel : arena.citadels)
            {
                citadelX = citadel.getX();
                citadelY = citadel.getY();
            }
        }
    }

    private boolean hitWall(double x, double y)
    {
        boolean hit = false;

      for(Wall targetWall : arena.getWalls())
        {
            if(x == targetWall.getX() && y == targetWall.getY())
            {
                hit = true;
                targetWall.setHit(true);
            }
        }
        return hit;
    }

    private boolean hitBrokenWall(double x, double y)
    {
        boolean hit = false;

        for(Wall brokenWall : arena.getBrokenWalls())
        {
            if(x == brokenWall.getX() && y == brokenWall.getY())
            {
                hit = true;
                brokenWall.setHit(true);
            }
        }

        return hit;
    }


    public void stopBuildingRobots() {
        executor.shutdownNow();
        System.out.println("Stopping building robots....");
    }

    public void stopMovingRobots()
    {
        movementExecutor.shutdown();
        System.out.println("Stopping robot from moving....");

    }

}
