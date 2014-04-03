package arvore234;

public class Node 
{
    private int numItems;
    private Node parent;
    private Node childArray[] = new Node[4];
    private DataItem itemArray[] = new DataItem[3];
    
    public void conectChild(int num, Node child)
    {
        childArray[num] = child;
        if(child != null)
            child.parent = this;
    }
    
    public Node disconectChild(int num)
    {
        Node temp = childArray[num];
        childArray[num] = null;
        return temp;
    }
    
    public Node getChild(int num)
    {
        return childArray[num];
    }
    
    public Node getParent()
    {
        return parent;
    }
    
    public boolean isLeaf()
    {
        return (childArray[0] == null) ? true:false;
    }
    
    public int getNumItems()
    {
        return numItems;
    }
    
    public DataItem getItem(int index)
    {
        return itemArray[index];
    }
    
    public boolean isFull()
    {
        return (numItems==3) ? true : false;
    }
    
    public int findItem(long key)
    {
        for(int i=0; i<3; i++)
        {
            if(itemArray[i]==null)
                break;
            else if(itemArray[i].dData == key)
                return i;
        }
        return -1;
    }
    
    public int insertItem(DataItem newItem)
    {
        numItems++;
        long newKey = newItem.dData;
        
        for(int i=2; i>=0; i--)
        {
            if(itemArray[i] == null)
                continue;
            else
            {
                long itsKey = itemArray[i].dData;
                if(newKey < itsKey)
                    itemArray[i+1] = itemArray[i];
                else
                {
                    itemArray[i+1] = newItem;
                    return i+1;
                }
            }
        }
        itemArray[0] = newItem;
        return 0;
    }
    
    public DataItem removeItem()
    {
        DataItem temp = itemArray[numItems - 1];
        itemArray[numItems-1] = null;
        numItems--;
        return temp;
    }
    
    public void displayNode()
    {
        for(int i=0; i<numItems; i++)
            itemArray[i].displayItem();
        System.out.println("/");
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
