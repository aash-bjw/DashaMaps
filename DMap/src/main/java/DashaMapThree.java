public class DashaMapThree implements HashMapX {

    private Node[] buckets;


    public DashaMapThree(){
        this.buckets = new Node[26];
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        for(int i = 0; i < this.buckets.length; i++){
            this.buckets[i] = new Node();
            this.buckets[i].setKey(String.valueOf(alphabet.charAt(i)));
        }
    }

    private String HashFunctionThree(String input) {
        if (input.length() > 1) {
            return String.valueOf(input.charAt(0)+input.charAt(1)).toLowerCase();
        }
        return null;
    }

    public Node firstLetter(String key){
        Node headNode;
        char firstLetter = HashFunctionThree(key).charAt(0);
        headNode = buckets[(firstLetter - 'a') %26];
        return headNode;
    }


    public void set(String key, String value){
        Node head = firstLetter(key);
        Node newNode = new Node(key,value);

        add(head,newNode);
    }


    public void add(Node head, Node newNode){
        while (head.next != null){
            head = head.next;
        }
        head.next = newNode;
    }


    public String delete(String key){
        Node currentNode = firstLetter(key);

        while (currentNode.next != null){
            if(currentNode.next.key.equals(key)){
                currentNode.next = currentNode.next.next;
                return "Node has been deleted.";
            }
            currentNode = currentNode.next;
        } return "Node doesn't exist";
    }


    public String get (String key){
        Node currentNode = firstLetter(key);

        while(currentNode.next != null){
            currentNode = currentNode.next;
            if(currentNode.key.equals(key)){
                return currentNode.value;
            }
        } return null;
    }


    public boolean isEmpty(){
        return size() == 0;
    }

    public long size() {
        Integer size = 0;
        for(Node n : buckets){
            while(n.next != null){
                n = n.next;
                size++;
            }
        } return size;
    }

    public boolean bucketSize(String key) {
        Node currentNode = firstLetter(key);
        return currentNode.next == null;
    }

}
