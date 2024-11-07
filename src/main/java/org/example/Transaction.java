package org.example;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    public enum Type {VIRINT, VIREST, VIRCHAC, VIRMULTA}
    private Date time;
    private String reference;
    private Set<Compte> comptes=new HashSet<>();
    Type type1;
   public  Type type_Transaction() {
       if (comptes.size() >2)
       {
           type1= Type.VIRMULTA;
       }
       if (comptes.size() == 2) {
           Compte comptesArray[] = comptes.toArray(new Compte[0]);
           Compte compte1 = comptesArray[0];
           Compte compte2 = comptesArray[1];
           if (compte1.getIdBanque().equals(compte2.getIdBanque()))
           {
               type1= Type.VIRINT;
           }
    else if(compte1.getIdBanque().getPay().equals(compte2.getIdBanque().getPay()))
           {
               type1= Type.VIREST;
           }
       } else{
           type1= Type.VIRCHAC;
       }
       return type1;
    }
    public String toJson() {
        Gson gson = new Gson();
        return gson.toJson(this); // Convertir l'objet actuel en JSON
    }
    // Conversion d'une chaîne JSON en objet Client
    public static Transaction fromJson(String json) {
        Gson gson = new Gson();
        return gson.fromJson(json,Transaction.class); // Convertir JSON en objet Client
    }
   }


