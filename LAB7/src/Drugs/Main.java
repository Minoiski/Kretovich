package Drugs;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException
    {

        List<Drug> drugList = new ArrayList<>();
        Drug drug1= new Drug(1, "Otrivin",10,9, "15.01.2019" );
        Drug drug2= new Drug(2, "Cetrine",15,4, "20.01.2019");
        drugList.add(drug1);
        drugList.add(drug2);

        RandomAccessFile file=new  RandomAccessFile("data.dat", "rw");
        List <Long> indexList= WorkWithFile.writeData(drugList, file);
        for(int i=0;i<indexList.size();i++)
        {
            Drug res=WorkWithFile.readData(file, i, indexList);
            System.out.println(res.toString());
        }

    }
}
