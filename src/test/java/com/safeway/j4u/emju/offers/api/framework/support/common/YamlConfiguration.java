package com.safeway.j4u.emju.offers.api.framework.support.common;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

import com.safeway.j4u.emju.offers.api.framework.support.database.DBConfiguration;


public class YamlConfiguration{

    public static void main(String[] args) throws IOException {

      Constructor constructor = new Constructor(DBConfiguration.class);
      Yaml yaml = new Yaml( constructor );
      InputStream input = null;
      try {
      input =
          new FileInputStream(new File("C:\\Automation\\Polaris API\\eCommFaceLift_API\\Polaris API\\DBConnection.yml"));

      } catch (FileNotFoundException e) {
        e.printStackTrace();
      }      DBConfiguration config = yaml.loadAs( input, DBConfiguration.class );
      System.out.println( config.toString() );
      System.out.println("pringing: "+config.getReleased());
      //Map<String, Map<String,String>> data = yaml.load(input);
      //System.out.println( data );
      //System.out.println( yaml.dump( data ));
    }
  }