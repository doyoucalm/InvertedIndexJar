/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test_tf_idf;

import java.util.Arrays;
import java.util.List;

/**
 *
 * @author christian
 */
public class TEST_TF_IDF {
    
     /**
     * @return hitung kemunculan kata dalam dokument
     */
    public double tf(List<String> doc, String term) {
        double result = 0;
        for (String word : doc) {
            if (term.equalsIgnoreCase(word))
                result++;
        }
        return result / doc.size();
    }

     /**

     * @return hitung kemunculan kata dalam kumpulan dokument atau data
     */
    public double idf(List<List<String>> docs, String term) {
        double n = 0;
        for (List<String> doc : docs) {
            for (String word : doc) {
                if (term.equalsIgnoreCase(word)) {
                    n++;
                    break;
                }
            }
        }
        return Math.log(docs.size() / n);
    }

    /**

     * @return ngembaliin nilai tf-idf
     */
    public double tfIdf(List<String> doc, List<List<String>> docs, String term) {
        return tf(doc, term) * idf(docs, term);

    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        List<String> doc1 = Arrays.asList("Lorem", "ipsum", "dolor", "ipsum", "sit", "ipsum");
        List<String> doc2 = Arrays.asList("ipsum", "incorrupte", "at", "ipsum", "pro", "quo");
        List<String> doc3 = Arrays.asList("Has", "persius", "disputationi", "ipsum", "Lorem");
        List<String> doc4 = Arrays.asList(" ", ",", "1", "2", "3");
        List<List<String>> documents = Arrays.asList(doc1, doc2, doc3,doc4);

        TEST_TF_IDF calculator = new TEST_TF_IDF();
        
        double tfidf1 = calculator.tfIdf(doc1, documents, "ipsum");
        double tfidf2 = calculator.tfIdf(doc2, documents, "ipsum");
        double tfidf3 = calculator.tfIdf(doc3, documents, "ipsum");
        
        System.out.println("TF-IDF (ipsum) = " + tfidf1);
        System.out.println("TF-IDF (ipsum) = " + tfidf2);
        System.out.println("TF-IDF (ipsum) = " + tfidf3);
    }
    
}
