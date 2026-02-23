class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<Character>();
        Map<Character,Character> m= new HashMap<>();
        m.put('}','{');
        m.put(']','[');
        m.put(')','(');
        char[] c=s.toCharArray();
        for(char i:c){
            if(m.containsValue(i)){
                st.push(i);
            }else if(m.containsKey(i)){
                if(st.isEmpty() || st.pop()!=m.get(i)){
                    return false;
                }
            }
        }
        return st.isEmpty();
        }
}