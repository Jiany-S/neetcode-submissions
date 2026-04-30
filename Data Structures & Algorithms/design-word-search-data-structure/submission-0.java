class WordDictionary {
    class Node{
        char c;
        Node[] children;
        boolean isEnd;
        public Node(char c){
            this.c = c;
            children = new Node[26];
            isEnd=false;
        }
    }
    Node root;
    public WordDictionary() {
        root = new Node('#');
    }

    public void addWord(String word) {
        Node curr = root;
        for(int i = 0; i<word.length();i++){
            char t = word.charAt(i);
            if(curr.children[t-'a']==null){
                curr.children[t-'a']= new Node(t);
            }
            curr = curr.children[t-'a'];
        }
        curr.isEnd=true;
    }

    public boolean search(String word) {
        return searchHelp(word,root);
    }
    boolean searchHelp(String word, Node root){
        if(root == null)
            return false;
        Node curr = root;
        for(int i = 0; i<word.length();i++){
            char t = word.charAt(i);
            if(t=='.'){
                boolean temp=false;
                for(int j = 0; j<26;j++){
                    if(temp==true)
                        break;
                    temp = temp||searchHelp(word.substring(i+1,word.length()),curr.children[j]);
                }
                return temp;
            }
            if(curr.children[t-'a']==null){
                return false;
            }
            curr = curr.children[t-'a'];
        }
        return curr.isEnd;
    }
}
