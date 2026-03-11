class Solution {
    public int bitwiseComplement(int n) {
        String num_str = Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder();
        for(char ch:num_str.toCharArray()){
            if(ch == '0'){
                sb.append('1');
            }else{
                sb.append('0');
            }
        }
        String str = sb.toString();
        return Integer.parseInt(str,2);
    }
}