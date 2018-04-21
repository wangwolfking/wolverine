package com.wolverine.file.fileOpretor.zip_unzip;
import java.io.*;
import java.util.zip.*;
public class TestFile
{
    public static void main ( String [ ] args ) throws IOException
    {
        // new a file input stream
        FileInputStream fis = new FileInputStream (
                "/home/liangruihua/ziptest/1.txt" ) ;
        BufferedInputStream bis = new BufferedInputStream ( fis ) ;

        // new a zipPutputStream
        // /home/liangruihua/ziptest/1.zip -- the out put file path and
        // name
        ZipOutputStream zos = new ZipOutputStream (
                new FileOutputStream (
                        "/home/liangruihua/ziptest/1.zip" ) ) ;
        BufferedOutputStream bos = new BufferedOutputStream ( zos ) ;

        // set the file name in the .zip file
        zos.putNextEntry ( new ZipEntry ( "1.txt" ) ) ;

        // set the declear
        zos.setComment ( "by liangruihua test!" ) ;

        byte [ ] b = new byte [ 100 ] ;
        while ( true )
        {
            int len = bis.read ( b ) ;
            if ( len == - 1 )
                break ;
            bos.write ( b , 0 , len ) ;
        }
        fis.close ( ) ;
        zos.close ( ) ;
    }
}
