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
        Drug drug3= new Drug(10, "No-Shpa",5,7, "20.02.2019");

        drugList.add(drug1);
        drugList.add(drug2);
        drugList.add(drug3);


        RandomAccessFile file=new  RandomAccessFile("data.dat", "rw");
        ArrayList <Long> indexList= Connector.writeData(drugList, file);
        for(int i=0;i<indexList.size();i++)
        {
            Drug res=Connector.readData(file, i, indexList);
            System.out.println(res.toString());
        }

        System.out.println("\nИндексирование по полю\n");
        try
        {
            Map<Object, Long> IndexMap = Connector.writeDataByField(drugList, file, "costOfPack");
            Object[] keys=IndexMap.keySet().toArray();
            Arrays.sort(keys);

            System.out.println("Сортировка по возрастанию");
            for(Object i:keys)
            {
                Drug res= Connector.readDataByField(file,i,IndexMap);
                assert res != null;
                System.out.println(res.toString());
            }

            Arrays.sort(keys, Collections.reverseOrder());
            System.out.println("\nСортировка по убыванию");
            for(Object i:keys)
            {
                Drug res= Connector.readDataByField(file,i,IndexMap);
                assert res != null;
                System.out.println(res.toString());
            }


            ArrayList<Drug>  res;

            System.out.println("\nПоиск объекта по индексу");
            res= Connector.searchByIndex(IndexMap, drug3.getFieldName("costOfPack"), file, 0);
            assert res != null;
            for(Drug i: res) {
                System.out.println(i.toString());
            }

            res.clear();
            System.out.println("\nВывод всех объектов по индексу больше указанного");
            res= Connector.searchByIndex(IndexMap, drug3.getFieldName("costOfPack"), file, 1);
            assert res != null;
            for(Drug i: res)
                System.out.println(i.toString());

            res.clear();
            System.out.println("\nВывод всех объектов по индексу меньше указанного");
            res= Connector.searchByIndex(IndexMap, drug3.getFieldName("costOfPack"), file, -1);
            assert res != null;
            for(Drug i: res)
                System.out.println(i.toString());


            System.out.println("\nУдаление по индексу");
            Connector.removeByIndex(IndexMap,drug3.getFieldName("costOfPack"),file);
            for(Object i:keys)
            {
                Drug res3= Connector.readDataByField(file,i,IndexMap);
                if(res3!=null){
                    System.out.println(res3.toString());
                }}
        }
        catch (IllegalAccessException | NoSuchFieldException e){

            e.printStackTrace();

        }

    }
}

