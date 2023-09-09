import java.util.Scanner;
class Node{
    Node[] links;
    boolean flag;
    int countEndWith = 0;

    int countPrefix = 0;
    public Node(){
        links = new Node[26];
        flag = false;
    }

    public boolean containsKey(char ch){
        return (links[ch-'a']!=null);
    }

    public void put(char ch,Node node){
        links[ch-'a']=node;
    }
 
    public Node get(char ch){
        return links[ch-'a'];
    }

    public void increasePrefix(){
        countPrefix++;
    }

    public void increaseEnd(){
        countEndWith++;
    }

    public int getPrefix(){
        return countPrefix;
    }
    public int getEnd(){
        return countEndWith;
    }

    public void reducePrefix() {
        countPrefix--;
    }

    public void reduceEnd() {
        countEndWith--;
    }

    public void setEnd(){
        flag = true;
    }

    public boolean isEnd(){
        return flag;
    }

}
class Trie {
    private static Node root;

    public Trie() {
        //creating new object
        root = new Node();
    }

    public void insert(String word) {
        //initializing dummy node pointing to root initially
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            //moves to reference trie
            node = node.get(word.charAt(i));
            // increasing prefix count
            node.increasePrefix();
        }
        //Setting last reference as true
        node.setEnd();
        // increasing ending word count
        node.increaseEnd();
    }

    public boolean search(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.get(word.charAt(i));
        }
        // Checking if a given word is a complete word or not
        return node.isEnd();
    }

    public boolean startsWith(String prefix) {
        Node node = root;
        for (int i = 0; i < prefix.length(); i++) {
            if (!node.containsKey(prefix.charAt(i))) {
                return false;
            }
            node = node.get(prefix.charAt(i));
        }
        return true;
    }

    public int countWordsEqualTo(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
            }else{
                return 0;
            }
        }
        // getting the count of the words equal to the given word
        return node.getEnd();
    }

    public int countWordsStartingWith(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
            }else{
                return 0;
            }
        }
        // getting the count of the words starts with given word
        return node.getPrefix();
    }

    public void delete(String word){
        Node node = root;
        for(int i=0;i<word.length();i++){
            if(node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
                // reducing the character count
                node.reducePrefix();
            }else{
                return;
            }
        }
        // reducing the cound count at end
        node.reduceEnd();
    }
}

public class Main {
    public static void main(String[] args) {
        Trie trie = new Trie();
        Scanner sc = new Scanner(System.in);
        String word;
        while (true) {
            System.out.println("Enter your choice");
            System.out.println("1.Insert a word");
            System.out.println("2.Search a word");
            System.out.println("3.StartsWith(prefix) a word");
            System.out.println("4.Count words equal to the given word");
            System.out.println("5.Count words staring with given word");
            System.out.println("6.Delete a word");
            System.out.println("7.Exit");
            int choice = sc.nextInt();
            switch (choice) {
                case 1 -> {
                    System.out.println("Enter a word to insert");
                    word = sc.next();
                    trie.insert(word);
                }
                case 2 -> {
                    System.out.println("Enter a word to search");
                    word = sc.next();
                    System.out.println(trie.search(word));
                }
                case 3 -> {
                    System.out.println("Enter a word to find startsWith(prefix)");
                    word = sc.next();
                    System.out.println(trie.startsWith(word));
                }
                case 4 ->{
                    System.out.println("Enter the word to find the occurrence count");
                    word = sc.next();
                    System.out.println(trie.countWordsEqualTo(word));
                }
                case 5 ->{
                    System.out.println("Enter the word to find startsWith(prefix) count");
                    word = sc.next();
                    System.out.println(trie.countWordsStartingWith(word));
                }
                case 6 ->{
                    System.out.println("Enter the word to delete");
                    word = sc.next();
                    trie.delete(word);
                }
                case 7 -> System.exit(0);
                default -> System.out.println("Enter a correct choice");
            }
            System.out.println("----------------------------------------------------");
            System.out.println("----------------------------------------------------");
            System.out.println("----------------------------------------------------");
        }
    }
}

