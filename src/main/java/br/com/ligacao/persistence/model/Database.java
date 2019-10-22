package br.com.ligacao.persistence.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;

import br.com.ligacao.persistence.connection.Connection;

/**
 * Classe responsável por gerenciar os dados com o banco Firestore.
 */
public class Database {  
    
    /**
     * Conexão com o banco Firestore
     */
    static Firestore db = Connection.getConnection();
        
    /**
     * Método responsável por cadastrar ou atualizar um novo 
     * promotor de ação no banco de dados Firebase.
     * Caso o registro não exista, um novo documento será criado,
     * caso já exista, as informações enviadas serão atualizadas.
     * 
     * @param nomePromotor Nome do promotor de ação.
     * @param categoriaAcao Categoria em que se enquadra a ONG.
     * @param cpfResponsavel Cpf do responsável pela ONG.
     * @param dataFundacao Data de fundação da ONG.
     * @param descricao Descrição das atividades da ONG.
     * @param email Endereço eletrônico da ONG.
     * @param imagem Imagem/logo que identifica a ONG.
     * @param redeSocial Link para rede social da ONG.
     * @param telefone Número de telefone da ONG.
     * @param usuario Nome de usuário de login da ONG.
     * @param senha Senha de login da ONG.
     */
    public static void cadastraPromotor(String nomePromotor,
                            String categoriaAcao,
                            String cpfResponsavel,
                            String dataFundacao,
                            String descricao,
                            String email,
                            String imagem,
                            String redeSocial,
                            String telefone,
                            String usuario,
                            String senha) throws IOException, InterruptedException, ExecutionException {
        
        Firestore db = Database.db;
        
        DocumentReference referenciaPromotor = db.collection("promotor de acao").document(nomePromotor);
        // Add document data using a hashmap
        Map<String, Object> promotorAcao = new HashMap<>();
        promotorAcao.put("nomePromotor", nomePromotor);
        promotorAcao.put("categoriaAcao", categoriaAcao);
        promotorAcao.put("cpfResponsavel", cpfResponsavel);
        promotorAcao.put("dataFundacao", dataFundacao);
        promotorAcao.put("descricao", descricao);
        promotorAcao.put("email", email);
        promotorAcao.put("imagem", imagem);
        promotorAcao.put("redeSocial", redeSocial);
        promotorAcao.put("telefone", telefone);
        promotorAcao.put("usuario", usuario);
        promotorAcao.put("senha", senha);
        //asynchronously write data
        ApiFuture<com.google.cloud.firestore.WriteResult> resultPromotor = referenciaPromotor.set(promotorAcao);
     // ...
        // result.get() blocks on response
        System.out.println("Update time : " + resultPromotor.get().getUpdateTime());
    }

    /**
     * Método responsável por cadastrar ou atualizar uma nova 
     * ação de um promotor de ação no banco de dados Firebase.
     * Caso o registro não exista, um novo documento será criado,
     * caso já exista, as informações enviadas serão atualizadas.
     * 
     * @param nomePromotor Nome do promotor da ação.
     * @param nomeAcao Nome que identifica a ação que será realizada.
     * @param categoriaAcao Categoria que se enquada a ação.
     * @param dataRealizacao Data de realização prevista da ação.
     * @param descricao Descrição das atividades que serão exercidas na ação.
     * @param horaInicio Horário de início previsto da ação.
     * @param horaFim Horário de encerramento previsto da ação.
     */
    public static void cadastraAcao(String nomePromotor,
            String nomeAcao,
            String categoriaAcao,
            String dataRealizacao,
            String descricao,
            String horaInicio,
            String horaFim) throws IOException, InterruptedException, ExecutionException {

        Firestore db = Database.db;
        
        DocumentReference referenciaAcao = db.collection("promotor de acao").document(nomePromotor)
                                               .collection("acoes").document(nomeAcao);
        
        // Add document data using a hashmap
        Map<String, Object> promotorAcao = new HashMap<>();
        promotorAcao.put("nomeAcao", nomeAcao);
        promotorAcao.put("categoriaAcao", categoriaAcao);
        promotorAcao.put("dataRealizacao", dataRealizacao);
        promotorAcao.put("dataRealizacao", dataRealizacao);
        promotorAcao.put("descricao", descricao);
        promotorAcao.put("horaInicio", horaInicio);
        promotorAcao.put("horaFim", horaFim);
        //asynchronously write data
        ApiFuture<com.google.cloud.firestore.WriteResult> resultAcao = referenciaAcao.set(promotorAcao);
        // ...
        // result.get() blocks on response
        System.out.println("Update time : " + resultAcao.get().getUpdateTime());
        
    }
    
    public static Promotor consultaPromotor(String nomePromotor) throws InterruptedException, ExecutionException {
        Firestore db = Database.db;
        
        DocumentReference docRef = db.collection("promotor de acao").document(nomePromotor);
        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
        // ...
        
        DocumentSnapshot document1 = future.get();

        Promotor promotor = null;
        if (document1.exists()) {
          // convert document to POJO
          promotor = document1.toObject(Promotor.class);
          System.out.println(promotor);
        } else {
          System.out.println("No such document!");
        }
        
        //System.out.println(promotor.getRedeSocial());
        
        // future.get() blocks on response
        DocumentSnapshot document = null;
        try {
            document = future.get();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (document.exists()) {
            System.out.println("Document data: " + document.getData());
        } else {
            System.out.println("No such document!");
        }
        
        return promotor;
    }
    
    public static Acao consultaAcao(String nomePromotor, String nomeAcao) throws InterruptedException, ExecutionException {
        Firestore db = Database.db;
        
        DocumentReference docRef = db.collection("promotor de acao").document(nomePromotor)
                                    .collection("acoes").document(nomeAcao);
        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
        // ...
        
        DocumentSnapshot document1 = future.get();

        Acao acao = null;
        if (document1.exists()) {
          // convert document to POJO
          acao = document1.toObject(Acao.class);
          System.out.println(acao);
        } else {
          System.out.println("No such document!");
        }
        
        // future.get() blocks on response
        DocumentSnapshot document = null;
        try {
            document = future.get();
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (document.exists()) {
            System.out.println("Document data: " + document.getData());
        } else {
            System.out.println("No such document!");
        }
        
        return acao;
    }

}

