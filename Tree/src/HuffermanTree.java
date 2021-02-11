import java.util.*;

public class HuffermanTree {
    public static HashMap<Byte,String> code=new HashMap<>();
    public static Node construct(String str){
        HashMap<Byte, Integer> map = new HashMap<>();
        byte []arr=str.getBytes();
        for (byte c : arr ){

            if (!map.containsKey(c)){
                map.put(c,1);
            }
            else {
                Integer integer = map.get(c);
                int value=integer+1;
                map.put(c,value);
            }
        }
        List<Node> list=new ArrayList<>();
        for (Map.Entry<Byte, Integer> entry : map.entrySet()) {
            Node node = new Node(entry.getValue());
            node.data=entry.getKey();
            list.add(node);


        }
        while(list.size()>1){
            Collections.sort(list);
            Node left=list.get(0);
            Node right=list.get(1);
            Node node=new Node(left.value+right.value);
            node.left=left;
            node.right=right;
            list.add(node);
            list.remove(right);
            list.remove(left);
        }
        return list.get(0);
    }
    public static void preSout(String str){
        preSout(construct(str));
    }
    private static void preSout(Node root){
        System.out.print(root);
        if(root.left!=null){
            preSout(root.left);
        }
        if(root.right!=null){
            preSout(root.right);
        }
    }
    public static HashMap<Byte,String> getHuffermanCode(String str){
        Node root=construct(str);
        getCode(root,"",new StringBuilder());
        return code;
    }
    public static void getCode(Node node,String sb,StringBuilder preSb){

        if (node==null){
            return ;
        }

        StringBuilder S=new StringBuilder(preSb);
        S.append(sb);

        if (node.data==null){
            getCode(node.left,"0",S);
            getCode(node.right,"1",S);

        }else{
            code.put(node.data,S.toString());
        }
    }

    public static byte[]zipByte(String str){
        int length;
        HashMap<Byte, String> code = getHuffermanCode(str);
        StringBuilder sb=new StringBuilder();
        byte arr[]=str.getBytes();
        for (byte b : arr) {
            sb.append(code.get(b));
        }
        if (sb.length()%8==0){
          length=sb.length()/8;
        }
        else{
            length=sb.length()/8+1;
        }
        byte []zip=new byte[length];
        int index=0;
        for (int i = 0; i <sb.length() ; i+=8) {
            if (index!=length-1){
            zip[index++]=(byte)Integer.parseInt(sb.substring(i,i+8),2);}
            else{
                zip[index]=(byte)Integer.parseInt(sb.substring(i),2);
            }
        }
        System.out.println(sb);
 return zip;
    }

}
