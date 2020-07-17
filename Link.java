public class Link {
    public static void main(String[] args) {
        List_Node L = new List_Node();
        
        L.AddLastData("Mon");
        L.AddLastData("Wed");
        L.AddLastData("Sun");

        Create_Node Search = L.SearchNode("Wed");
        if (Search.getData() == null) {
            System.out.println("Not Found Data");
        } else {
            L.AddMiddleData(Search, "Fri");
        }

        L.PrintList();
    }
}

class List_Node {
    Create_Node head = new Create_Node();

    public void AddMiddleData(Create_Node pre, String data) {
        Create_Node new_node = new Create_Node(data);
        new_node.link = pre.link;
        pre.link = new_node;
    }

    public void AddLastData(String data) {
        Create_Node new_node = new Create_Node(data);
        if (head == null) {
            head = new_node;
        } else {
            Create_Node tmp;
            tmp = head;
            while(tmp.link != null) {
                tmp = tmp.link;
            }
            tmp.link = new_node;
        }
    }

    public Create_Node SearchNode(String Data) {
        Create_Node tmp = head.link;
        while(tmp != null) {
            if (tmp.getData() == Data)
            {
                break;
            }
            tmp = tmp.link;
        }
        return tmp;
    }

    public void PrintList() {
        Create_Node tmp;
        tmp = head.link;
        while (tmp != null) {
            System.out.printf("%s", tmp.getData());
            tmp = tmp.link;
            if (tmp != null) {
                System.out.printf(", ");
            }
        }
    }
}

class Create_Node {
    private String data;
    public Create_Node link;

    public Create_Node() {
        data = null;
        link = null;
    }

    public Create_Node(String data) {
        this.data = data;
        link = null;
    }

    public String getData() {
        return data;
    }
}