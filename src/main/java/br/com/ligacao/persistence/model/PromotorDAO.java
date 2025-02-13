package br.com.ligacao.persistence.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;

import br.com.ligacao.persistence.connection.Connection;

/**
 * Classe responsável por gerenciar os dados de promotores de ação no banco Firestore.
 */
public class PromotorDAO {

    /**
     * Método responsável por cadastrar ou atualizar um novo
     * promotor fisico de ação no banco de dados Firebase.
     * Caso o registro não exista, um novo documento será criado,
     * caso já exista, as informações enviadas serão atualizadas.
     *
     * @param promotor Objeto promotor de ação.
     * @throws IOException exceção de entrada e saída
     * @throws InterruptedException exceção de interrupção
     * @throws ExecutionException exceção de execução
     */
    public static void cadastraPromotorFisico(final PromotorFisico promotor)
            throws IOException, InterruptedException, ExecutionException {

        String nomePessoa = promotor.getNomePessoa();
        String cpf = promotor.getCpf();
        String dataNascimento = promotor.getDataNascimento();
        String fotoPerfil = promotor.getFotoPerfil();
        String redesSociais = promotor.getRedesSociais();
        String categoriasAcoes = promotor.getCategoriasAcoes();
        String telefone = promotor.getTelefone();
        String descricaoGeral = promotor.getDescricaoGeral();
        String endereco = promotor.getEndereco();
        String email = promotor.getEmail();

        String usuario = promotor.getUsuario();
        String senha = promotor.getSenha();

        Firestore db = Connection.db;

        DocumentReference referenciaPromotor = db.collection("promotor de acao").document(nomePessoa);
        // Add document data using a hashmap
        Map<String, Object> promotorAcao = new HashMap<String, Object>();
        promotorAcao.put("tipoPessoa", "fisica");
        promotorAcao.put("nomePessoa", nomePessoa);
        promotorAcao.put("cpf", cpf);
        promotorAcao.put("dataNascimento", dataNascimento);
        promotorAcao.put("fotoPerfil", fotoPerfil);
        promotorAcao.put("redesSociais", redesSociais);
        promotorAcao.put("categoriasAcoes", categoriasAcoes);
        promotorAcao.put("telefone", telefone);
        promotorAcao.put("descricaoGeral", descricaoGeral);
        promotorAcao.put("endereco", endereco);
        promotorAcao.put("email", email);
        //asynchronously write data
        ApiFuture<com.google.cloud.firestore.WriteResult> resultPromotor = referenciaPromotor.set(promotorAcao);
     // ...
        // result.get() blocks on response
        System.out.println("Update time : " + resultPromotor.get().getUpdateTime());

        DocumentReference referenciaLogin = db.collection("promotor de acao").document(nomePessoa)
                .collection("login").document("dados");

        // Add document data using a hashmap
        Map<String, Object> login = new HashMap<String, Object>();
        login.put("usuario", usuario);
        login.put("senha", senha);

        ApiFuture<com.google.cloud.firestore.WriteResult> resultLogin = referenciaLogin.set(login);
        // ...
           // result.get() blocks on response
           System.out.println("Update time : " + resultLogin.get().getUpdateTime());
    }

    /**
     * Método responsável por cadastrar ou atualizar um novo
     * promotor fisico de ação no banco de dados Firebase.
     * Caso o registro não exista, um novo documento será criado,
     * caso já exista, as informações enviadas serão atualizadas.
     *
     * @param promotor Objeto promotor de ação.
     * @throws IOException exceção de entrada e saída
     * @throws InterruptedException exceção de interrupção
     * @throws ExecutionException exceção de execução
     */
    public static void cadastraPromotorJuridico(final PromotorJuridico promotor)
            throws IOException, InterruptedException, ExecutionException {

        String nomePessoaResponsavel = promotor.getNomePessoaResponsavel();
        String cpfResponsavel = promotor.getCpfResponsavel();
        String cnpj = promotor.getCnpj();
        String razaoSocial = promotor.getRazaoSocial();
        String fotoPerfil = promotor.getFotoPerfil();
        String dataFundacao = promotor.getDataFundacao();
        String redesSociais = promotor.getRedesSociais();
        String categoriasAcoes = promotor.getCategoriasAcoes();
        String telefone = promotor.getTelefone();
        String descricaoGeral = promotor.getDescricaoGeral();
        String endereco = promotor.getEndereco();
        String email = promotor.getEmail();

        String usuario = promotor.getUsuario();
        String senha = promotor.getSenha();

        Firestore db = Connection.db;

        DocumentReference referenciaPromotor = db.collection("promotor de acao").document(razaoSocial);
        // Add document data using a hashmap
        Map<String, Object> promotorAcao = new HashMap<String, Object>();
        promotorAcao.put("tipoPessoa", "juridica");
        promotorAcao.put("nomePessoaResponsavel", nomePessoaResponsavel);
        promotorAcao.put("cpfResponsavel", cpfResponsavel);
        promotorAcao.put("cnpj", cnpj);
        promotorAcao.put("razaoSocial", razaoSocial);
        promotorAcao.put("fotoPerfil", fotoPerfil);
        promotorAcao.put("dataFundacao", dataFundacao);
        promotorAcao.put("redesSociais", redesSociais);
        promotorAcao.put("categoriasAcoes", categoriasAcoes);
        promotorAcao.put("telefone", telefone);
        promotorAcao.put("descricaoGeral", descricaoGeral);
        promotorAcao.put("endereco", endereco);
        promotorAcao.put("email", email);
        //asynchronously write data
        ApiFuture<com.google.cloud.firestore.WriteResult> resultPromotor = referenciaPromotor.set(promotorAcao);
     // ...
        // result.get() blocks on response
        System.out.println("Update time : " + resultPromotor.get().getUpdateTime());

        DocumentReference referenciaLogin = db.collection("promotor de acao").document(razaoSocial)
                .collection("login").document("dados");

        // Add document data using a hashmap
        Map<String, Object> login = new HashMap<String, Object>();
        login.put("usuario", usuario);
        login.put("senha", senha);

        ApiFuture<com.google.cloud.firestore.WriteResult> resultLogin = referenciaLogin.set(login);
        // ...
           // result.get() blocks on response
           System.out.println("Update time : " + resultLogin.get().getUpdateTime());
    }

    /**
     * Método responsável por excluir um promotor de ação.
     *
     * @param nomePromotor Nome do promotor da ação.
     * @throws InterruptedException exceção de interrupção
     * @throws ExecutionException exceção de execução
     */
    public static void excluiPromotor(final String nomePromotor)
        throws InterruptedException, ExecutionException {

        Firestore db = Connection.db;

        DocumentReference referenciaPromotor = db.collection("promotor de acao").document(nomePromotor);
        DocumentReference referenciaLogin = db.collection("promotor de acao").document(nomePromotor).
                collection("promotor de acao").document("dados");

     // asynchronously delete a document
        ApiFuture<WriteResult> writeResult = referenciaPromotor.delete();
        ApiFuture<WriteResult> writeResult2 = referenciaLogin.delete();
        // ...
        System.out.println("Update time : " + writeResult.get().getUpdateTime());
        System.out.println("Update time : " + writeResult2.get().getUpdateTime());
    }

    /**
     * Método responsável por consultar se um dado
     * promotor é pessoa Física ou Juridica.
     *
     * @param nomePromotor Nome do promotor da ação.
     *
     * @return Retorna o tipo de pessoa do promotor.
     * @throws InterruptedException exceção de interrupção
     * @throws ExecutionException exceção de execução
     */
    public static String consultaTipoPromotor(final String nomePromotor)
        throws InterruptedException, ExecutionException {
        Firestore db = Connection.db;

        DocumentReference docRef = db.collection("promotor de acao").document(nomePromotor);
        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
        // ...

        String tipoPessoa = future.get().getString("tipoPessoa");

        return tipoPessoa;

    }

    /**
     * Método responsável por consultar dados cadastrados
     * de um promotor físico de ação.
     *
     * @param nomePromotor Nome do promotor da ação.
     *
     * @return Retorna uma classe PromotorFisico com os dados consultados.
     * @throws InterruptedException exceção de interrupção
     * @throws ExecutionException exceção de execução
     */
    public static PromotorFisico retornaPromotorFisico(final String nomePromotor)
        throws InterruptedException, ExecutionException {
        Firestore db = Connection.db;

        DocumentReference docRef = db.collection("promotor de acao").document(nomePromotor);
        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
        // ...
        DocumentSnapshot document1 = future.get();

        PromotorFisico promotor = null;
        if (document1.exists()) {
          // convert document to POJO
          promotor = document1.toObject(PromotorFisico.class);
          System.out.println(promotor);
        } else {
          System.out.println("No such document!");
        }
        return promotor;
    }

    /**
     * Método responsável por consultar dados cadastrados
     * de um promotor jurídico de ação.
     *
     * @param nomePromotor Nome do promotor da ação.
     *
     * @return Retorna uma classe PromotorJuridico com os dados consultados.
     * @throws InterruptedException exceção de interrupção
     * @throws ExecutionException exceção de execução
     */
    public static PromotorJuridico retornaPromotorJuridico(final String nomePromotor)
        throws InterruptedException, ExecutionException {
        Firestore db = Connection.db;

        DocumentReference docRef = db.collection("promotor de acao").document(nomePromotor);
        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
        // ...
        DocumentSnapshot document1 = future.get();

        PromotorJuridico promotor = null;
        if (document1.exists()) {
          // convert document to POJO
          promotor = document1.toObject(PromotorJuridico.class);
          System.out.println(promotor);
        } else {
          System.out.println("No such document!");
        }
        return promotor;
    }

    /**
     * Realiza as busca dos dados do PromotorFisico através de um usuario e senha
     * informado por parametro.
     *
     * @param user     nome de usuario cadastrado no perfil de promotor fisico.
     * @param password senha cadastrado no perfil de promotor fisico.
     *
     * @return caso seja encontrado o perfil de Promotor fisico com os parametros
     *             informados irá retornar uma instancia da classe com os atributos
     *             preenchidos. Caso contrario, deverá retornar NULL.
     * @throws InterruptedException exceção de interrupção
     * @throws ExecutionException exceção de execução
     */
    public static PromotorFisico loginPromotorFisico(final String user, final String password)
            throws InterruptedException, ExecutionException {
        List<PromotorFisico> promotores = new ArrayList<PromotorFisico>();

        promotores = consultaPromotoresFisicos();

        for (PromotorFisico promotor : promotores) {
            if (consultaUsuario(promotor.getNomePessoa()).equals(user)
                    && consultaSenha(promotor.getNomePessoa()).equals(password)) {
                    return promotor;
            }
        }
        return null;
    }

    /**
     * Realiza as busca dos dados do PromotorJuridico através de um usuario e senha
     * informado por parametro.
     *
     * @param user     nome de usuario cadastrado no perfil de promotor juridico.
     * @param password senha cadastrado no perfil de promotor juridico.
     *
     * @return caso seja encontrado o perfil de Promotor Juridico com os parametros
     *             informados irá retornar uma instancia da classe com os atributos
     *             preenchidos. Caso contrario, deverá retornar NULL.
     * @throws InterruptedException exceção de interrupção
     * @throws ExecutionException exceção de execução
     */
    public static PromotorJuridico loginPromotorJuridico(final String user, final String password)
            throws InterruptedException, ExecutionException {
        List<PromotorJuridico> promotores = new ArrayList<PromotorJuridico>();

        promotores = consultaPromotoresJuridicos();

        for (PromotorJuridico promotor : promotores) {
            if (consultaUsuario(promotor.getRazaoSocial()).equals(user)
                    && consultaSenha(promotor.getRazaoSocial()).equals(password)) {
                    return promotor;
            }
        }
        return null;
    }

    /**
     * Método responsável por consultar nome de usuário
     * do login de um promotor de ação.
     *
     * @param nomePromotor Nome do promotor da ação.
     *
     * @return Retorna uma String com o nome de usuário.
     * @throws ExecutionException exceção de execução
     * @throws InterruptedException exceção de interrupção
     */
    public static String consultaUsuario(final String nomePromotor)
     throws InterruptedException, ExecutionException {
        Firestore db = Connection.db;

        DocumentReference docRef = db.collection("promotor de acao").document(nomePromotor)
                                        .collection("login").document("dados");
        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
        // ...

        // future.get() blocks on response
        String document = null;
        try {
            document = future.get().getString("usuario");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (document != null) {
            return document;
        } else {
            return null;
        }
    }

    /**
     * Método responsável por consultar senha
     * do login de um promotor de ação.
     *
     * @param nomePromotor Nome do promotor da ação.
     *
     * @return Retorna uma String com a senha de usuário.
     */
    public static String consultaSenha(final String nomePromotor) {
        Firestore db = Connection.db;

        DocumentReference docRef = db.collection("promotor de acao").document(nomePromotor)
                                        .collection("login").document("dados");
        // asynchronously retrieve the document
        ApiFuture<DocumentSnapshot> future = docRef.get();
        // ...

        // future.get() blocks on response
        String document = null;
        try {
            document = future.get().getString("senha");
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ExecutionException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (document != null) {
            return document;
        } else {
            return null;
        }
    }

    /**
     * Método responsável por alterar senha
     * do login de um promotor de ação.
     *
     * @param nomePromotor Nome do promotor da ação.
     * @param senha Senha do usuário do promotor da ação.
     * @param usuario Nome de usuario.
     * @throws IOException exceção de entrada e saída
     * @throws InterruptedException exceção de interrupção
     * @throws ExecutionException exceção de execução
     */
    public static void alteraSenha(final String nomePromotor, final String usuario, final String senha)
     throws IOException, InterruptedException, ExecutionException {

        Firestore db = Connection.db;

       DocumentReference referenciaLogin = db.collection("promotor de acao").document(nomePromotor)
                .collection("login").document("dados");

        // Add document data using a hashmap
        Map<String, Object> loginMap = new HashMap<String, Object>();
        loginMap.put("usuario", usuario);
        loginMap.put("senha", senha);

        ApiFuture<com.google.cloud.firestore.WriteResult> resultLogin = referenciaLogin.set(loginMap);
        // ...
           // result.get() blocks on response
           System.out.println("Update time : " + resultLogin.get().getUpdateTime());
    }

    /**
     * Método responsável por consultar promotores cadastrados
     * em uma ação.
     *
     * @return Retorna uma lista de objetos Promotor.
     * @throws InterruptedException exceção de interrupção
     * @throws ExecutionException exceção de execução
     */
    public static List<PromotorFisico> consultaPromotoresFisicos()
            throws InterruptedException, ExecutionException {

        Firestore db = Connection.db;

        CollectionReference referenciaPromotores = db.collection("promotor de acao");

     // Create a query against the collection.
        Query query = referenciaPromotores.whereEqualTo("tipoPessoa", "fisica");

      //asynchronously retrieve multiple documents
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        // future.get() blocks on response
        List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();
        List<PromotorFisico> promotores = new ArrayList<PromotorFisico>();
        for (DocumentSnapshot document : documents) {
          //System.out.println(document.getId() + " adicionado");
          promotores.add(document.toObject(PromotorFisico.class));
        }
        return promotores;
    }

    /**
     * Método responsável por consultar promotores cadastrados
     * em uma ação.
     *
     * @return Retorna uma lista de objetos Promotor.
     * @throws InterruptedException exceção de interrupção
     * @throws ExecutionException exceção de execução
     */
    public static List<PromotorJuridico> consultaPromotoresJuridicos()
            throws InterruptedException, ExecutionException {

        Firestore db = Connection.db;

        CollectionReference referenciaPromotores = db.collection("promotor de acao");

     // Create a query against the collection.
        Query query = referenciaPromotores.whereEqualTo("tipoPessoa", "juridica");

      //asynchronously retrieve multiple documents
        ApiFuture<QuerySnapshot> querySnapshot = query.get();
        // future.get() blocks on response
        List<QueryDocumentSnapshot> documents = querySnapshot.get().getDocuments();
        List<PromotorJuridico> promotores = new ArrayList<PromotorJuridico>();
        for (DocumentSnapshot document : documents) {
          //System.out.println(document.getId() + " adicionado");
          promotores.add(document.toObject(PromotorJuridico.class));
        }
        return promotores;
    }
}
