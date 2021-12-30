package accesBaseDeDonnees;

import java.sql.*;

public class BDD {
    private static Connection cn=null;
    public static void main(String[] args) {

        String url = "jdbc:mysql://mysql2.pedago.local.enit.fr/***";
        String login = "student";
        String password ="Enit@65";
        try{
            //Etape 1 : Changement du driver
            Class.forName("java.sql.Driver");
            //Etape 2 : récupération de la connexion
            cn= DriverManager.getConnection(url, login, password);
            // Ajouter un produit
            //Etape 1 : créer la requete insert
            String query_insert= "insert into produit (nomProduit, marque, prix, stock)" + "values (?,?,?,?)";
            //Etape 2 : créer le preparedstatement
            PreparedStatement preparedStmt_insert = cn.prepareStatement(query_insert);
            preparedStmt_insert.setString(1, "yaourt");
            preparedStmt_insert.setString(2, "pyrenees");
            preparedStmt_insert.setDouble(3, 0.45);
            preparedStmt_insert.setInt(4, 235);
            //Etape 3 : exécuter le preparedstatement
            preparedStmt_insert.execute();
            //Sélectionner les produits
            // Etape 1: créer la requête select
            String query_select = "select * from produit where prix>?";
            // Etape 2: créer le preparedstatement
            PreparedStatement preparedStmt_select = cn.prepareStatement(query_select);
            preparedStmt_select.setDouble(1,0.4);
            // Etape 3: executer le preparestatement
            ResultSet result = preparedStmt_select.executeQuery();
            // Etape 4: parcour et afficher le résultat
            while (result.next()) {
                System.out.println(result.getString("nomProduit"));
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                cn.close();
            } catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
