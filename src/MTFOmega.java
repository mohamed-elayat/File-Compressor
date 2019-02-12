
//Mohamed Elayat et Fatima Mostefai

import java.io.FileReader;
import java.io.IOException;

public class MTFOmega {

    public LinkedList list;
    BinaryOut out;


    //constructor to create a LinkedList of specified size
    public MTFOmega(  int size  ){
        this.list = new LinkedList(  size  );
        out = new BinaryOut();
    }


    //Method that takes integer and returns its index in the permutation.
    // It also manages the move-to-front transformation in the permutation.
    public int encodeMTF(  int val  ){

        int index = 0;
        Node n = list.head;

        while (n.next != null) {

            if (n.data == val){
                list.unlinkNode(n);
                list.linkFirst(n);
                break;
            }
            n = n.next;
            index++;

        }
        return index;
    }


    //Method that takes index and returns value of the permutation at this index.
    // It also manages the move-to-front transformation in the permutation.
    public int decodeMTF(int i){
        int val = 0;
        int index = 0;

        Node n = list.head;
        while (n.next != null) {

            if (index == i){
                list.unlinkNode(n);
                list.linkFirst(n);
                val = n.data;
                break;
            }
            n = n.next;
            index++;

        }
        return val;
    }



    //Method encodes an integer using Omega encryption.
    //After writing the encrypted number, it writes a 0
    public void encodeOmega(int n){
        Omega0(  n  );
        out.write(  false  );
    }



    //Recursive method that takes care of calling
    //Beta ( BetaLength(n) - 1 ) and Beta (n) until
    //it reaches the base case
    public void Omega0(  int n  ){

        if(  n == 0  ){}

        else {
            int x = BetaLength(  n  );
            Omega0(  x  - 1  );
            Beta(n);
        }

    }


    //Method that calculates the length of the binary
    //notation of a number
    public int BetaLength(  int n  ){

        if(  n != 0  ) {
            int x = (int) Math.floor(Math.log(n) / Math.log(2) + 1);
            return x;
        }
        else{
            return 0;
        }

    }


    //Recursive method that calculates the binary notation
    //of an integer. It writes each digit of the binary notation
    // to System.out as it's going.
    public void Beta(  int n  ){

        if(  n == 0  ){}

        else if(  n == 1  ){
            out.write(  true  );
        }

        else if(  n % 2 == 0  ){
            Beta(  n/2  );
            out.write(  false  );
        }

        else if(  n % 2 == 1  ){
            Beta(  (n-1)/2  );
            out.write(  true  );
        }

    }



    public static void main(String[] args) throws IOException {

        MTFOmega mtf = new MTFOmega(65536);     //instance of a LinkedList of size 65535 (2^16)

        FileReader reader = new FileReader(  args[0]  );    //FileReader to read the bytes of the input file
        int result = reader.read();

        while(  result !=  -1  ){
            mtf.encodeOmega(  mtf.encodeMTF(  result  )  );     //write the output file as we're reading each byte
            result = reader.read();
        }

        mtf.out.flush();

    }

}
