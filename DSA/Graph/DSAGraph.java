import java.util.*;
import java.io.*;
public class DSAGraph
{

	DSALinkedList vertices;
	Object value = null;

	public DSAGraph()
	{
		vertices = new DSALinkedList();
	}
	
	public void addVertex(String inLabel, Object inValue)
	{
		if(hasVertex(inLabel)==false)
		{
			DSAGraphVertex vertex = new DSAGraphVertex(inLabel, inValue);
			vertices.insertLast(vertex);
		}
	}

	public void addVertex(String inLabel)
	{
		if(hasVertex(inLabel)==false)
		{
			DSAGraphVertex vertex = new DSAGraphVertex(inLabel);
			vertices.insertLast(vertex);
		}
	}

	public boolean hasVertex(String inLabel)
	{
		boolean found = false;
		DSAGraphVertex tempVertex;
		Iterator itVertices= vertices.iterator();
		while(itVertices.hasNext())
		{
			tempVertex = (DSAGraphVertex) itVertices.next();
			if(tempVertex.getLabel().equals(inLabel))
			{
				found = true;
			}
		}
		return found;
	}

	public Integer getVertexCount()
	{
		Integer count = vertices.getLength();
		return count;
	}

	public void addEdge(String inLabel1, String inLabel2)
	{
		addVertex(inLabel1);
		addVertex(inLabel2);
		getVertex(inLabel1).addLink(getVertex(inLabel2));

	}

	public DSAGraphVertex getVertex(String inLabel)
	{
		DSAGraphVertex returnVertex = null;
		DSAGraphVertex tempVertex;
		Iterator itVertices = vertices.iterator();
		while(itVertices.hasNext())
		{
			tempVertex = (DSAGraphVertex) itVertices.next();
			if(tempVertex.getLabel().equals(inLabel))
			{
				returnVertex = tempVertex;
			}
		}
		return returnVertex;
	}

	public DSALinkedList getAdjacent(String inLabel)
	{
		DSALinkedList returnList = null;
		Iterator itVertices = vertices.iterator();
		DSAGraphVertex tempVertex;
		while(itVertices.hasNext())
		{
			tempVertex = (DSAGraphVertex) itVertices.next();
			if(tempVertex.getLabel().equals(inLabel))
			{
				returnList = tempVertex.getAdjacent();
			}
		}
		return returnList;
	}

	public void display()
	{
		System.out.println("DISPLAYING GRAPH IN ADJACENCY LIST :");
		Iterator itVertices = vertices.iterator();
		DSAGraphVertex tempVertex;
		DSAGraphVertex tempLink;


		while(itVertices.hasNext())
		{
			tempVertex = (DSAGraphVertex) itVertices.next();
			System.out.println();
			System.out.print(tempVertex.getLabel() + " | ");
			Iterator itLink = tempVertex.getAdjacent().iterator();
			System.out.print(" -> ");
			while(itLink.hasNext())
			{
				tempLink = (DSAGraphVertex) itLink.next();
				System.out.print(tempLink.getLabel() + "  ");
			}
		}
		System.out.println("");
	}

	public DSAGraph readFile(String inFile)
	{

		DSAGraph newGraph = new DSAGraph();


		FileInputStream fis = null;
		InputStreamReader inputStreamReader;
		BufferedReader bufferedReader;

		String line;
		try
		{
			fis = new FileInputStream(inFile);
			inputStreamReader = new InputStreamReader(fis);
			bufferedReader = new BufferedReader(inputStreamReader);
			line = bufferedReader.readLine();

			while(line!=null)
			{
				String[] data = line.split(" ");
				newGraph.addEdge(data[0], data[1]);
				line = bufferedReader.readLine();

			}
			System.out.println("Successfully read file");
			fis.close();
		}catch(IOException e)
		{
			System.out.println("Error in file processing : " + e.getMessage());
		}
		return newGraph;
	}


	// public void bFS(String inLabel)
	// {
	// 	DSAGraphVertex startVertex = getVertex(inLabel);
	// 	DSAQueue bfsQueue = new DSAQueue();
	// 	System.out.println(bfsSub(startVertex, bfsQueue));
	// }

	// private String bfsSub(DSAGraphVertex inVertex, DSAQueue bfsQueue)
	// {
	// 	DSAGraphVertex currVertex;
	// 	String out = "";
	// 	String curr;

	// 	bfsQueue.enqueue(inVertex.getLabel());

	// 	while(!bfsQueue.isEmpty())
	// 	{
	// 		curr = (String) bfsQueue.dequeue();
	// 		currVertex = getVertex(curr);
	// 		if(!currVertex.getVisited())
	// 		{
	// 			out = out +currVertex.getLabel();
	// 			currVertex.setVisited();

	// 			Iterator itAdjacent = currVertex.getAdjacent().iterator();

	// 			while(itAdjacent.hasNext())
	// 			{
	// 				currVertex = (DSAGraphVertex) itAdjacent.next();
	// 				bfsQueue.enqueue(currVertex.getLabel());
	// 			} 
	// 		}
	// 	}
	// 	Iterator itVertices = vertices.iterator();

 //        while (itVertices.hasNext())
 //        {
 //            currVertex = (DSAGraphVertex) itVertices.next();
 //            currVertex.clearVisted();
 //        }

 //        return out;
	// }

	public void dFS(String inLabel)
	{	
		DSAGraphVertex currVertex;
		DSAGraphVertex startVertex = getVertex(inLabel);
		String out = "";
		dFSSub(startVertex, out);

		Iterator itVertices = vertices.iterator();
		while(itVertices.hasNext())
		{
			currVertex = (DSAGraphVertex) itVertices.next();
			currVertex.clearVisted();
		}
	}
	private void dFSSub(DSAGraphVertex inVertex, String r)
	{
		DSAGraphVertex currVertex;
		Iterator itVertices = inVertex.getAdjacent().iterator();
		System.out.print(inVertex.getLabel());
		inVertex.setVisited();

		while(itVertices.hasNext())
		{
			currVertex = (DSAGraphVertex) itVertices.next();
			if(!currVertex.getVisited())
			{
				dFSSub(currVertex, r);
			}
		}

	}






}