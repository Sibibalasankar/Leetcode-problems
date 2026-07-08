// Last updated: 7/8/2026, 4:58:52 PM
class Solution {
    public int passwordStrength(String password) {
         HashSet<Character> set = new HashSet<>();

        String pass=password;
        int score =0;

        for(char c:pass.toCharArray()){

            if(!set.contains(c)){
                set.add(c);

                if(c>='a' && c<='z'){
                    score+=1;
                }else if(c>='A' && c<='Z'){
                    score+=2;
                }else if(c>='0' && c<='9'){
                    score+=3;
            }else if("@$!#".indexOf(c) != -1){
                score+=5;
            }
            }
        }
    return score;
    }
}