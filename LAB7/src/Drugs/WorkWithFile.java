package Drugs;

import java.io.*;
import java.util.ArrayList;
import java.util.*;

public class WorkWithFile {
    private static byte[] serialize(Drug obj) throws IOException {

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {

            objectOutputStream.writeObject(obj);
            objectOutputStream.flush();
            return byteArrayOutputStream.toByteArray();

        } catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
        return null;
    }

    private static Drug deserialize(byte[] arr) throws IOException {
        ByteArrayInputStream baos=new ByteArrayInputStream(arr);
        try (ObjectInputStream oin = new ObjectInputStream(baos)) {
            return (Drug)oin.readObject();
        }
        catch (Exception ex) {

            System.out.println(ex.getMessage());
        }
        return null;
    }

    public static List<Long>  writeData(List <Drug> list,  RandomAccessFile file) throws IOException {

        List <Long> indexList = new ArrayList<>();
        for(Drug i : list) {

            indexList.add(file.getFilePointer());
            byte[] arr=serialize(i);
            file.write(arr);
        }

        return indexList;
    }


    public static Drug readData(RandomAccessFile file, int index, List <Long> indexList) throws IOException {

        file.seek(indexList.get(index));
        byte[] arr = new byte[1024];
        file.read(arr);
        return deserialize(arr);
    }
}
