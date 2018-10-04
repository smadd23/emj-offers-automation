package com.safeway.j4u.emju.offers.api.framework.support.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import org.apache.commons.lang3.RandomStringUtils;

/** Current class is to generate different kinds of Random numbers. @Author Bharath */
public class RandomGenerator {

  public static Random rand = new Random();
  public static DateAndTime dateAndTime = new DateAndTime();

  /** To Generate Random Numbers of the Entered Length. */
  public static String generateRandomNumber(int length) {
    if (length > 18) {
      throw new IllegalStateException("To many digits");
    }
    long tlen = (long) Math.pow(10, length - 1) * 9;
    long number = (long) (Math.random() * tlen) + (long) Math.pow(10, length - 1) * 1;
    String randomValue = number + "";
    if (randomValue.length() != length) {
      throw new IllegalStateException(
          "The random number '" + randomValue + "' is not '" + length + "' digits");
    }
    return randomValue;
  }

  /**
   * To Generate Random Capitalized Letters of the Entered Length.
   *
   * @param length defines the length of random number
   * @return Random number created based on length
   */
  public static String generateRandomCapitalizedString(int length) {
    StringBuffer output = new StringBuffer(1000);
    output.append((char) (rand.nextInt(26) + 'A'));
    System.out.println(output.toString());

    for (int i = 1; i < 10; i++) {
      char c = (char) (rand.nextInt(26) + 'a');
      output.append(c);
    }
    String randCapitalizedString = output.toString();
    return randCapitalizedString;
  }

  /**
   * Generate Random Small Letters of the Entered Length.
   *
   * @param length defines the lenght of Random letter
   * @return the generated random letter
   */
  public static String generateRandomSmallLetters(int length) {
    StringBuffer output = new StringBuffer(1000);
    output.append((char) (rand.nextInt(26) + 'a'));
    System.out.println(output.toString());

    for (int i = 1; i < 10; i++) {
      char c = (char) (rand.nextInt(26) + 'a');
      output.append(c);
    }
    String randSmallLetters = output.toString();
    return randSmallLetters;
  }

  /**
   * Generate Random Capital Letters of the Entered Length.
   *
   * @param length defines the random capital letters.
   * @return generated random capital letter word.
   */
  public static String generateRandomCapitalLetters(int length) {
    StringBuffer output = new StringBuffer(1000);
    output.append((char) (rand.nextInt(26) + 'A'));
    System.out.println(output.toString());

    for (int i = 1; i < 10; i++) {
      char c = (char) (rand.nextInt(26) + 'A');
      output.append(c);
    }
    String randCapitalLetters = output.toString();
    return randCapitalLetters;
  }

  /**
   * Generate Random Alpha-Numeric Characters of the Entered Length.
   *
   * @param length of random alpha numeric characters
   * @return the generated random character
   */
  public static String generaterandomalphanumericcharacters(int length) {
    return RandomStringUtils.randomAlphanumeric(length).toString();
  }

  /**
   * Generate Random ASCII Characters of the Entered Length.
   *
   * @param length of random ascii characters.
   * @return generated ascii characters.
   */
  public static String generaterandomasciicharacters(int length) {
    return RandomStringUtils.randomAscii(length).toString();
  }

  /**
   * Generate Random E-Mail IDs(Auto Generate Domain Names.
   *
   * @return the random email id.
   * @throws Exception if any issue.
   */
  public static String generaterandomemailids() throws Exception {

    String emailid =
        "autotester_"
            + RandomGenerator.generateRandomNumber(5)
            + new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
    String domain = "example";
    return emailid + "@" + domain + ".com";
  }

  /**
   * Generate Random E-Mail IDs.
   *
   * @param domainName generate the random email id.
   * @return generated random email id.
   */
  public static String generaterandomemailids(String domainName) {
    String emailId = RandomStringUtils.randomAlphabetic(15).toString();
    return emailId + "@" + domainName;
  }
}
