package edu.curtin.saed.assignment1;

import edu.curtin.saed.assignment1.model.Wall;
import javafx.application.Platform;

import java.util.concurrent.*;

public class WallLogic
{
    private final JFXArena jfxArena;
    public final BlockingQueue<Wall> wallQueue;
    private final ScheduledExecutorService wallExecutor;
    private final int maxNoOfWalls = 10;
    public int currentNoOfWalls = 0;

    public WallLogic(JFXArena jfxArena)
    {
        this.jfxArena = jfxArena;
        this.wallExecutor = Executors.newScheduledThreadPool(1);
        this.wallQueue = new LinkedBlockingQueue<>(maxNoOfWalls);
    }

    public void run()
    {
        wallExecutor.scheduleAtFixedRate(this::buildWalls, 0, 2000, TimeUnit.MILLISECONDS);
    }

    public void buildAWall(double x, double y)
    {
        //wallQueue stores the x & y coordinates of the map in a queue, when a block is clicked.
        if(wallQueue.size() < maxNoOfWalls)
        {
            wallQueue.offer(new Wall(x, y));
        }
    }


    public void buildWalls()
    {
        while(true)
        {
            try
            {
                //move this line below the if statement if you want to only create 10 walls.
                //Wall coordinates = wallQueue.take();

                if(currentNoOfWalls<maxNoOfWalls)
                {
                    Wall coordinates = wallQueue.take();

                    if(!jfxArena.isRobotPresent(coordinates.getX(), coordinates.getY()))
                    {

                        Platform.runLater(() -> {
                            jfxArena.addWalls(coordinates.getX(), coordinates.getY());
                        });
                        currentNoOfWalls = currentNoOfWalls + 1;
                        Thread.sleep(1000);
                        jfxArena.newEventInstance("Wall created at :" + coordinates.getX()+ ", " + coordinates.getY());
                        System.out.println("Walls count : "  + currentNoOfWalls);
                    }
                }
                if(currentNoOfWalls==maxNoOfWalls)
                {
                    return;
                }

            }catch(Exception e)
            {
                Thread.currentThread().interrupt();
                break;
            }

        }
    }

    public void reduceCurrNoOfWalls()
    {
        currentNoOfWalls = currentNoOfWalls - 1;
        System.out.println("Walls count : "  + currentNoOfWalls);
    }

    public void stopBuildingWalls()
    {
        wallExecutor.shutdown();
    }

}
