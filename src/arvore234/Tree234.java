package arvore234;

public class Tree234 
{
    private Node root = new Node();
    
    public int find(long key)
    {
        Node curNode = root;
        int childNum;
        
        while(true)
        {
            if((childNum = curNode.findItem(key)) != -1)
                return childNum;
            else if(curNode.isLeaf())
                return -1;
            else
                curNode = getNextChild(curNode, key);
        }
    }
    
    public void insert(long dValue)
    {
        Node curNode =root;
        DataItem temp = new DataItem(dValue);
        
        while(true)
        {
            if(curNode.isFull())
            {
                split(curNode);
                curNode = curNode.getParent();
                curNode = getNextChild(curNode, dValue);
            }
            else if(curNode.isLeaf())
                break;
            else
                curNode = getNextChild(curNode, dValue);
        }
        curNode.insertItem(temp);
    }
    
    public void split(Node thisNode)
    {
        DataItem itemB, itemC;
        Node parent, child2, child3;
        int itemIndex;
        
        itemC = thisNode.removeItem();
        itemB = thisNode.removeItem();
        child2 = thisNode.disconectChild(2);
        child3 = thisNode.disconectChild(3);
        
        Node newRight = new Node();
        
        if(thisNode == root)
        {
            root = new Node();
            parent = root;
            root.conectChild(0, thisNode);
        }
        else
        {
            parent = thisNode.getParent();
        }
        
        itemIndex = parent.insertItem(itemB);
        int n = parent.getNumItems();
        
        for(int i=n-1; i>itemIndex; i--)
        {
            Node temp =parent.disconectChild(i);
            parent.conectChild(i+1, temp);
        }
        
        parent.conectChild(itemIndex+1, newRight);
        
        newRight.insertItem(itemC);
        newRight.conectChild(0, child2);
        newRight.conectChild(1, child3);
    }
    
    public Node getNextChild(Node theNode, long theValue)
    {
        int i;
        int numItems = theNode.getNumItems();
        
        for(i=0; i<numItems; i++)
        {
            if(theValue < theNode.getItem(i).dData)
                return theNode.getChild(i);
        }
        return theNode.getChild(i);        
    }
    
    public void displayTree()
    {
        recDisplayTree(root, 0, 0);
    }
    
    private void recDisplayTree(Node thisNode, int level, int childNumber)
    {
        System.out.println("level="+level+" child="+childNumber+" ");
        thisNode.displayNode();
        int numItems = thisNode.getNumItems();
        
        for(int i=0; i<=numItems; i++)
        {
            Node nextNode = thisNode.getChild(i);
            if(nextNode != null)
                recDisplayTree(nextNode, level+1, i);
            else
                return;
        }
    }
    
    
    
}






















































