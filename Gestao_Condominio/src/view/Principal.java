/*
 * Trabalho de TCC ADS
 * Título: Sistema de Gestão de Condomínio
 * Início: 
 * Término: 
 */
package view;

import classe.DadosCondominio;
import classe.Funcionario;
import classe.Apartamento;
import classe.Morador;
import view.Login;
import java.sql.ResultSet;
import java.util.Arrays;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ayrton Hasegawa
 */

public class Principal extends javax.swing.JFrame {

    DadosCondominio dadosCondominio = new DadosCondominio();
    String salvar, user;

    ResultSet rsCondominio = dadosCondominio.consultaGeralFuncionario();
    ResultSet rsCondominioApartamento = dadosCondominio.consultaGeralApartamento();
    ResultSet rsCondominioMorador = dadosCondominio.consultaGeralMorador();

    Login login = new Login();
    Funcionario funcionario = new Funcionario();
    Apartamento apartamento = new Apartamento();
    Morador morador = new Morador();

    public Principal() {
        initComponents();
        lblMsg.setText(dadosCondominio.getCon());
        //lblNome_Fun.setText(login.chama());
        exibeGridFuncionario(rsCondominio);
        exibeGridApartamento(rsCondominioApartamento);
        exibeGridMorador(rsCondominioMorador);
        statusInicio();
    }

    private void statusInicio() {
        statusInicioFuncionario(true);
        statusInicioApartamento(true);
        statusInicioMorador(true);
        statusInicioVisita(true);
        statusInicioVeiculo(true);
    }

    //------------------------Funcionário----------------------------
    private void statusInicioFuncionario(boolean status) {
        txtCodFun.setEnabled(!status);
        txtNomeFun.setEnabled(!status);
        txtCpfFun.setEnabled(!status);
        txtCargoFun.setEnabled(!status);
        txtTelefoneFun.setEnabled(!status);
        txtEnderecoFun.setEnabled(!status);
        txtLoginFun.setEnabled(!status);
        txtSenhaFun.setEnabled(!status);

        btnConsultarFun.setEnabled(status);
        btnIncluirFun.setEnabled(status);
        btnLocalizarCodFun.setEnabled(!status);
        btnLocalizarCpfFun.setEnabled(!status);
        btnExcluirFun.setEnabled(!status);
        btnSalvarFun.setEnabled(!status);
        radioSimFun.setEnabled(!status);
        radioNaoFun.setEnabled(!status);
    }

    private void statusConsultarFuncionario(boolean status) {
        txtCodFun.setEnabled(status);
        txtNomeFun.setEnabled(!status);
        txtCpfFun.setEnabled(status);
        txtCargoFun.setEnabled(!status);
        txtTelefoneFun.setEnabled(!status);
        txtEnderecoFun.setEnabled(!status);
        txtLoginFun.setEnabled(!status);
        txtSenhaFun.setEnabled(!status);

        btnConsultarFun.setEnabled(status);
        btnIncluirFun.setEnabled(status);
        btnLocalizarCodFun.setEnabled(status);
        btnLocalizarCpfFun.setEnabled(status);
        btnExcluirFun.setEnabled(!status);
        btnSalvarFun.setEnabled(!status);

        radioSimFun.setEnabled(!status);
        radioNaoFun.setEnabled(!status);
    }

    private void statusAlterarFuncionario(boolean status) {
        txtCodFun.setEnabled(!status);
        txtNomeFun.setEnabled(status);
        txtCpfFun.setEnabled(status);
        txtCargoFun.setEnabled(status);
        txtTelefoneFun.setEnabled(status);
        txtEnderecoFun.setEnabled(status);
        txtLoginFun.setEnabled(!status);
        txtSenhaFun.setEnabled(status);

        btnConsultarFun.setEnabled(status);
        btnIncluirFun.setEnabled(status);
        btnLocalizarCodFun.setEnabled(!status);
        btnLocalizarCpfFun.setEnabled(!status);
        btnExcluirFun.setEnabled(status);
        btnSalvarFun.setEnabled(status);

        radioSimFun.setEnabled(status);
        radioNaoFun.setEnabled(status);
    }

    private void statusIncluirFuncionario(boolean status) {
        txtCodFun.setEnabled(!status);
        txtNomeFun.setEnabled(status);
        txtCpfFun.setEnabled(status);
        txtCargoFun.setEnabled(status);
        txtTelefoneFun.setEnabled(status);
        txtEnderecoFun.setEnabled(status);
        txtLoginFun.setEnabled(!status);
        txtSenhaFun.setEnabled(status);

        btnConsultarFun.setEnabled(status);
        btnIncluirFun.setEnabled(!status);
        btnLocalizarCodFun.setEnabled(!status);
        btnLocalizarCpfFun.setEnabled(!status);
        btnExcluirFun.setEnabled(!status);
        btnSalvarFun.setEnabled(status);

        radioSimFun.setEnabled(status);
        radioNaoFun.setEnabled(status);
    }

    private void exibeGridFuncionario(ResultSet rs) {
        DefaultTableModel tabelaFun = new DefaultTableModel(null, new String[]{"Código", "CPF", "Nome", "Cargo",
            "Telefone", "Endereco", "Ativo", "Login"/*,"Senha"*/});

        try {
            rs.first();
            while (!rs.isAfterLast()) {
                String[] dados = new String[8];
                dados[0] = rs.getString("Fun_Cod_Funcionario");
                dados[1] = rs.getString("Fun_CPF");
                dados[2] = rs.getString("Fun_Nome");
                dados[3] = rs.getString("Fun_Cargo");
                dados[4] = rs.getString("Fun_Telefone");
                dados[5] = rs.getString("Fun_Endereco");
                dados[6] = rs.getString("Fun_Ativo");
                dados[7] = rs.getString("Fun_Login");

                tabelaFun.addRow(dados);
                rs.next();
            }
        } catch (Exception e) {
        }

        jTableFuncionario.setModel(tabelaFun);
    }

    private void limparFuncionario() {
        txtCodFun.setText("");
        txtNomeFun.setText("");
        txtCpfFun.setText("");
        txtCargoFun.setText("");
        txtTelefoneFun.setText("");
        txtEnderecoFun.setText("");
        txtLoginFun.setText("");
        txtSenhaFun.setText("123456");
        grupoBotaoFuncionario.clearSelection();
    }

    //------------------- Apartamento --------------------------
    private void statusInicioApartamento(boolean status) {

        txtCodApartamento.setEnabled(!status);
        txtBlocoApartamento.setEnabled(!status);
        txtNumeroApartamento.setEnabled(!status);
        txtEstacionamento1.setEnabled(!status);
        txtEstacionamento2.setEnabled(!status);

        btnIncluirApartamento.setEnabled(status);
        btnExcluirApartamento.setEnabled(!status);
        btnSalvarApartamento.setEnabled(!status);
        btnLocalizarCodApartamento.setEnabled(!status);
    }

    private void statusConsultarApartamento(boolean status) {
        txtCodApartamento.setEnabled(status);
        txtBlocoApartamento.setEnabled(!status);
        txtNumeroApartamento.setEnabled(!status);
        txtEstacionamento1.setEnabled(!status);
        txtEstacionamento2.setEnabled(!status);

        btnIncluirApartamento.setEnabled(status);
        btnExcluirApartamento.setEnabled(!status);
        btnSalvarApartamento.setEnabled(!status);
        btnLocalizarCodApartamento.setEnabled(status);
    }

    private void statusAlterarApartamento(boolean status) {
        txtCodApartamento.setEnabled(!status);
        txtBlocoApartamento.setEnabled(status);
        txtNumeroApartamento.setEnabled(status);
        txtEstacionamento1.setEnabled(!status);
        txtEstacionamento2.setEnabled(!status);

        btnIncluirApartamento.setEnabled(status);
        btnExcluirApartamento.setEnabled(status);
        btnSalvarApartamento.setEnabled(status);
        btnLocalizarCodApartamento.setEnabled(!status);
    }

    private void statusIncluirApartamento(boolean status) {

        txtCodApartamento.setEnabled(!status);
        txtBlocoApartamento.setEnabled(status);
        txtNumeroApartamento.setEnabled(status);
        txtEstacionamento1.setEnabled(!status);
        txtEstacionamento2.setEnabled(!status);

        btnIncluirApartamento.setEnabled(!status);
        btnExcluirApartamento.setEnabled(!status);
        btnSalvarApartamento.setEnabled(status);
        btnLocalizarCodApartamento.setEnabled(!status);
    }

    private void exibeGridApartamento(ResultSet rs) {
        DefaultTableModel tabelaApart = new DefaultTableModel(null, new String[]{"Código do Apartamento", "Bloco do Prédio", "Número do Apartamento",
            "Estacionamento vaga 1", "Estacionamento vaga 2"});
        try {
            rs.first();
            while (!rs.isAfterLast()) {
                String[] dados = new String[5];
                dados[0] = rs.getString("Ap_Cod_Apartamento");
                dados[1] = rs.getString("Ap_Bloco_Predio");
                dados[2] = rs.getString("Ap_Num_Apartamento");
                dados[3] = rs.getString("Ap_Num_Vaga1");
                dados[4] = rs.getString("Ap_Num_Vaga2");

                tabelaApart.addRow(dados);
                rs.next();
            }
        } catch (Exception e) {
        }
        jTableApartamento.setModel(tabelaApart);
    }

    private void limparApartamento() {
        txtCodApartamento.setText("");
        txtBlocoApartamento.setText("");
        txtNumeroApartamento.setText("");
        txtEstacionamento1.setText("");
        txtEstacionamento2.setText("");
    }

    //------------------- Morador ------------------
    private void statusInicioMorador(boolean status) {
        txtCpfMorador.setEnabled(!status);
        txtNomeMorador.setEnabled(!status);
        txtTelefoneMorador.setEnabled(!status);
        txtEmailMorador.setEnabled(!status);
        txtBlocoApartamentoMorador.setEnabled(!status);
        txtNumeroApartamentoMorador.setEnabled(!status);

        btnIncluirMorador.setEnabled(status);
        btnExcluirMorador.setEnabled(!status);
        btnSalvarMorador.setEnabled(!status);
        btnLocalizarCpfMorador.setEnabled(!status);
        btnLocalizarNomeMorador.setEnabled(!status);

        radioSimMorador.setEnabled(!status);
        radioNaoMorador.setEnabled(!status);
    }

    private void statusConsultarMorador(boolean status) {
        txtCpfMorador.setEnabled(status);
        txtNomeMorador.setEnabled(status);
        txtTelefoneMorador.setEnabled(!status);
        txtEmailMorador.setEnabled(!status);
        txtBlocoApartamentoMorador.setEnabled(!status);
        txtNumeroApartamentoMorador.setEnabled(!status);

        btnIncluirMorador.setEnabled(status);
        btnExcluirMorador.setEnabled(!status);
        btnSalvarMorador.setEnabled(!status);
        btnLocalizarCpfMorador.setEnabled(status);
        btnLocalizarNomeMorador.setEnabled(status);
        radioSimMorador.setEnabled(!status);
        radioNaoMorador.setEnabled(!status);
    }

    private void statusAlterarMorador(boolean status) {
        txtCpfMorador.setEnabled(status);
        txtNomeMorador.setEnabled(status);
        txtTelefoneMorador.setEnabled(status);
        txtEmailMorador.setEnabled(status);
        txtBlocoApartamentoMorador.setEnabled(status);
        txtNumeroApartamentoMorador.setEnabled(status);

        btnIncluirMorador.setEnabled(status);
        btnExcluirMorador.setEnabled(status);
        btnSalvarMorador.setEnabled(status);
        btnLocalizarCpfMorador.setEnabled(!status);
        btnLocalizarNomeMorador.setEnabled(!status);
        radioSimMorador.setEnabled(status);
        radioNaoMorador.setEnabled(status);
    }

    private void statusIncluirMorador(boolean status) {
        txtCpfMorador.setEnabled(status);
        txtNomeMorador.setEnabled(status);
        txtTelefoneMorador.setEnabled(status);
        txtEmailMorador.setEnabled(status);
        txtBlocoApartamentoMorador.setEnabled(status);
        txtNumeroApartamentoMorador.setEnabled(status);

        btnIncluirMorador.setEnabled(!status);
        btnExcluirMorador.setEnabled(!status);
        btnSalvarMorador.setEnabled(status);
        btnLocalizarCpfMorador.setEnabled(!status);
        btnLocalizarNomeMorador.setEnabled(!status);
        radioSimMorador.setEnabled(status);
        radioNaoMorador.setEnabled(status);
    }

    private void exibeGridMorador(ResultSet rs) {
        DefaultTableModel tabelaMorador = new DefaultTableModel(null, new String[]{"Cpf do Morador", "Nome do Morador", "Email do Morador",
            "Telefone do Morador", "Mora no Apartamento", "Bloco do Prédio", "Num. do Apartamento"});

        try {
            rs.first();
            while (!rs.isAfterLast()) {
                Apartamento recebeApartamento = dadosCondominio.consultaCodigoApartamento(Integer.parseInt(rs.getString("Mor_Cod_Apartamento")));
                String[] dados = new String[7];
                dados[0] = rs.getString("Mor_CPF");
                dados[1] = rs.getString("Mor_Nome");
                dados[2] = rs.getString("Mor_Email");
                dados[3] = rs.getString("Mor_Telefone");
                dados[4] = rs.getString("Mor_Ativo");
                dados[5] = recebeApartamento.getBlocoApartamento();
                dados[6] = recebeApartamento.getNumeroApartamento();

                tabelaMorador.addRow(dados);
                rs.next();
            }
        } catch (Exception e) {
        }
        jTableMorador.setModel(tabelaMorador);
    }

    private void limparMorador() {
        txtCpfMorador.setText("");
        txtNomeMorador.setText("");
        txtTelefoneMorador.setText("");
        txtEmailMorador.setText("");
        txtBlocoApartamentoMorador.setText("");
        txtNumeroApartamentoMorador.setText("");
        grupoBotaoMorador.clearSelection();
    }

    //------------------- Visita ------------------
    private void statusInicioVisita(boolean status) {
        txtDataVisita.setEnabled(!status);
        txtHoraVisita.setEnabled(!status);
        txtCpfVisitanteVisita.setEnabled(!status);
        txtNomeVisitanteVisita.setEnabled(!status);
        txtCpfMoradorVisita.setEnabled(!status);
        txtTelefoneMoradorVisita.setEnabled(!status);
        txtNomeMoradorVisita.setEnabled(!status);

        btnIncluirVisita.setEnabled(status);
        btnIncluirVisitanteLista.setEnabled(!status);
        btnExcluirVisitanteLista.setEnabled(!status);
        btnExcluirVisita.setEnabled(!status);
    }

    //------------------- Veículo ------------------
    private void statusInicioVeiculo(boolean status) {
        txtPlacaVeiculo.setEnabled(!status);
        txtModeloVeiculo.setEnabled(!status);
        txtCorVeiculo.setEnabled(!status);
        txtFabricanteVeiculo.setEnabled(!status);
        txtCpfMoradorVeiculo.setEnabled(!status);
        txtNomeMoradorVeiculo.setEnabled(!status);
        txtBlocoApartamentoVeiculo.setEnabled(!status);
        txtNumeroApartamentoVeiculo.setEnabled(!status);

        btnConsultarVeiculo.setEnabled(status);
        btnIncluirVeiculo.setEnabled(!status);
        btnExcluirVeiculo.setEnabled(!status);
    }

    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoBotaoFuncionario = new javax.swing.ButtonGroup();
        grupoBotaoMorador = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnLogout = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btnSair = new javax.swing.JButton();
        lblNome_Fun = new javax.swing.JLabel();
        lblCargo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        painelFuncionario = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        txtNomeFun = new javax.swing.JTextField();
        txtCpfFun = new javax.swing.JTextField();
        btnLocalizarCodFun = new javax.swing.JButton();
        jLabel37 = new javax.swing.JLabel();
        txtCargoFun = new javax.swing.JTextField();
        jLabel38 = new javax.swing.JLabel();
        txtLoginFun = new javax.swing.JTextField();
        txtEnderecoFun = new javax.swing.JTextField();
        jLabel39 = new javax.swing.JLabel();
        txtCodFun = new javax.swing.JTextField();
        jLabel40 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        btnConsultarFun = new javax.swing.JButton();
        btnExcluirFun = new javax.swing.JButton();
        btnLimparFun = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableFuncionario = new javax.swing.JTable();
        btnSalvarFun = new javax.swing.JButton();
        btnLocalizarCpfFun = new javax.swing.JButton();
        btnIncluirFun = new javax.swing.JButton();
        jLabel43 = new javax.swing.JLabel();
        radioNaoFun = new javax.swing.JRadioButton();
        radioSimFun = new javax.swing.JRadioButton();
        jLabel45 = new javax.swing.JLabel();
        txtTelefoneFun = new javax.swing.JTextField();
        jLabel46 = new javax.swing.JLabel();
        txtSenhaFun = new javax.swing.JPasswordField();
        painelMorador = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableMorador = new javax.swing.JTable();
        btnConsultarMorador = new javax.swing.JButton();
        btnIncluirMorador = new javax.swing.JButton();
        btnLimparMorador = new javax.swing.JButton();
        btnSalvarMorador = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        txtNomeMorador = new javax.swing.JTextField();
        btnLocalizarNomeMorador = new javax.swing.JButton();
        jLabel54 = new javax.swing.JLabel();
        txtEmailMorador = new javax.swing.JTextField();
        btnLocalizarCpfMorador = new javax.swing.JButton();
        btnExcluirMorador = new javax.swing.JButton();
        jLabel55 = new javax.swing.JLabel();
        txtCpfMorador = new javax.swing.JTextField();
        jLabel61 = new javax.swing.JLabel();
        txtNumeroApartamentoMorador = new javax.swing.JTextField();
        jLabel62 = new javax.swing.JLabel();
        radioSimMorador = new javax.swing.JRadioButton();
        radioNaoMorador = new javax.swing.JRadioButton();
        jLabel63 = new javax.swing.JLabel();
        txtTelefoneMorador = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        txtBlocoApartamentoMorador = new javax.swing.JTextField();
        painelVisita = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaVisitanteNaVisita = new javax.swing.JTable();
        btnIncluirVisita = new javax.swing.JButton();
        jLabel65 = new javax.swing.JLabel();
        txtHoraVisita = new javax.swing.JTextField();
        btnLocalizarNomeMoradorVisita = new javax.swing.JButton();
        btnLimparVisita = new javax.swing.JButton();
        btnExcluirVisita = new javax.swing.JButton();
        btnExcluirVisitanteLista = new javax.swing.JButton();
        jLabel66 = new javax.swing.JLabel();
        txtTelefoneMoradorVisita = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        txtDataVisita = new javax.swing.JTextField();
        jScrollPane7 = new javax.swing.JScrollPane();
        jTableHistoricoVisita = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        tabelaMoradorVisita = new javax.swing.JTable();
        jLabel69 = new javax.swing.JLabel();
        txtCpfMoradorVisita = new javax.swing.JTextField();
        jLabel70 = new javax.swing.JLabel();
        txtNomeVisitanteVisita = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        txtCpfVisitanteVisita = new javax.swing.JTextField();
        btnLocalizarCpfVisitanteVisita = new javax.swing.JButton();
        jLabel72 = new javax.swing.JLabel();
        txtNomeMoradorVisita = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        btnSalvarVisita = new javax.swing.JButton();
        btnLocalizarCpfMoradorVisita = new javax.swing.JButton();
        btnIncluirVisitanteLista = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        painelVisitante = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableVisitante = new javax.swing.JTable();
        btnLimparVisitante = new javax.swing.JButton();
        btnExcluirVisitante = new javax.swing.JButton();
        btnSalvarVisitante = new javax.swing.JButton();
        jLabel73 = new javax.swing.JLabel();
        txtCpfVisitante = new javax.swing.JTextField();
        btnLocalizarCpfVisitante = new javax.swing.JButton();
        jLabel74 = new javax.swing.JLabel();
        txtNomeVisitante = new javax.swing.JTextField();
        btnLocalizarNomeVisitante = new javax.swing.JButton();
        painelApartamento = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableApartamento = new javax.swing.JTable();
        btnConsultarApartamento = new javax.swing.JButton();
        btnIncluirApartamento = new javax.swing.JButton();
        jLabel75 = new javax.swing.JLabel();
        txtCodApartamento = new javax.swing.JTextField();
        btnLocalizarCodApartamento = new javax.swing.JButton();
        btnLimparApartamento = new javax.swing.JButton();
        btnExcluirApartamento = new javax.swing.JButton();
        btnSalvarApartamento = new javax.swing.JButton();
        jLabel76 = new javax.swing.JLabel();
        txtBlocoApartamento = new javax.swing.JTextField();
        jLabel77 = new javax.swing.JLabel();
        txtNumeroApartamento = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        txtEstacionamento1 = new javax.swing.JTextField();
        jLabel79 = new javax.swing.JLabel();
        txtEstacionamento2 = new javax.swing.JTextField();
        jLabel89 = new javax.swing.JLabel();
        painelVeiculo = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableVeiculo = new javax.swing.JTable();
        btnConsultarVeiculo = new javax.swing.JButton();
        btnIncluirVeiculo = new javax.swing.JButton();
        jLabel80 = new javax.swing.JLabel();
        txtPlacaVeiculo = new javax.swing.JTextField();
        btnLocalizarPlacaVeiculo = new javax.swing.JButton();
        btnLimparVeiculo = new javax.swing.JButton();
        btnExcluirVeiculo = new javax.swing.JButton();
        btnSalvarVeiculo = new javax.swing.JButton();
        btnAlterarFun10 = new javax.swing.JButton();
        jLabel81 = new javax.swing.JLabel();
        txtModeloVeiculo = new javax.swing.JTextField();
        jLabel82 = new javax.swing.JLabel();
        txtFabricanteVeiculo = new javax.swing.JTextField();
        jLabel83 = new javax.swing.JLabel();
        txtCorVeiculo = new javax.swing.JTextField();
        jLabel84 = new javax.swing.JLabel();
        txtCpfMoradorVeiculo = new javax.swing.JTextField();
        jLabel85 = new javax.swing.JLabel();
        txtNomeMoradorVeiculo = new javax.swing.JTextField();
        jLabel86 = new javax.swing.JLabel();
        txtBlocoApartamentoVeiculo = new javax.swing.JTextField();
        jLabel87 = new javax.swing.JLabel();
        txtNumeroApartamentoVeiculo = new javax.swing.JTextField();
        jLabel88 = new javax.swing.JLabel();
        btnLocalizarCpfMoradorVeiculo = new javax.swing.JButton();
        jLabel90 = new javax.swing.JLabel();
        jPanel11 = new javax.swing.JPanel();
        lblMsg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistema de Gestão de Condomínio");
        setMaximumSize(new java.awt.Dimension(1366, 768));
        setMinimumSize(new java.awt.Dimension(1366, 690));
        setPreferredSize(new java.awt.Dimension(1366, 768));

        jPanel1.setBackground(new java.awt.Color(102, 102, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sistema de Gestão de Condomínios");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        btnLogout.setText("Logout");
        btnLogout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLogoutActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogout, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 20, -1, -1));

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setMinimumSize(new java.awt.Dimension(100, 300));
        jPanel2.setPreferredSize(new java.awt.Dimension(157, 500));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnSair.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/Sair.jpeg"))); // NOI18N
        btnSair.setText("SAIR");
        btnSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSairActionPerformed(evt);
            }
        });
        jPanel2.add(btnSair, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, -1, -1));

        lblNome_Fun.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblNome_Fun.setForeground(new java.awt.Color(255, 255, 255));
        lblNome_Fun.setText("Ayrton");
        jPanel2.add(lblNome_Fun, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, -1, -1));

        lblCargo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblCargo.setForeground(new java.awt.Color(255, 255, 255));
        lblCargo.setText("Portaria");
        jPanel2.add(lblCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/foto2.jpg"))); // NOI18N
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jTabbedPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jTabbedPane1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jTabbedPane1.setMinimumSize(new java.awt.Dimension(919, 500));

        painelFuncionario.setMaximumSize(new java.awt.Dimension(760, 768));
        painelFuncionario.setMinimumSize(new java.awt.Dimension(500, 400));
        painelFuncionario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setText("Funcionário");
        painelFuncionario.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setText("CPF do Funcionário:");
        painelFuncionario.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, -1, -1));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setText("Nome do Funcionário:");
        painelFuncionario.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 120, -1, -1));

        txtNomeFun.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelFuncionario.add(txtNomeFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 120, 360, -1));

        txtCpfFun.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelFuncionario.add(txtCpfFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 120, 130, -1));

        btnLocalizarCodFun.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLocalizarCodFun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/localizar2.png"))); // NOI18N
        btnLocalizarCodFun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizarCodFunActionPerformed(evt);
            }
        });
        painelFuncionario.add(btnLocalizarCodFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 20, 20));

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel37.setText("Cargo:");
        painelFuncionario.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        txtCargoFun.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelFuncionario.add(txtCargoFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, 230, -1));

        jLabel38.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel38.setText("Telefone:");
        painelFuncionario.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, -1, -1));

        txtLoginFun.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelFuncionario.add(txtLoginFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, 130, -1));

        txtEnderecoFun.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelFuncionario.add(txtEnderecoFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 160, 500, -1));

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel39.setText("Funcionário Ativo?");
        painelFuncionario.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, -1, -1));

        txtCodFun.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelFuncionario.add(txtCodFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 80, -1));

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel40.setText("Código do Funcionário:");
        painelFuncionario.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel42.setText("Lista de Funcionário");
        painelFuncionario.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 150, -1));

        btnConsultarFun.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnConsultarFun.setText("Consultar Funcionário");
        btnConsultarFun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarFunActionPerformed(evt);
            }
        });
        painelFuncionario.add(btnConsultarFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        btnExcluirFun.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExcluirFun.setText("Excluir Funcionário");
        btnExcluirFun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirFunActionPerformed(evt);
            }
        });
        painelFuncionario.add(btnExcluirFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 200, -1, -1));

        btnLimparFun.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLimparFun.setText("Limpar Campos");
        btnLimparFun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparFunActionPerformed(evt);
            }
        });
        painelFuncionario.add(btnLimparFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 200, -1, -1));

        jTableFuncionario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableFuncionario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Código", "Cpf", "Nome", "Cargo", "Telefone", "Endereço", "Ativo", "Login", "Senha"
            }
        ));
        jTableFuncionario.setRowHeight(22);
        jTableFuncionario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableFuncionarioMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jTableFuncionario);

        painelFuncionario.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 1100, 170));

        btnSalvarFun.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalvarFun.setText("Salvar");
        btnSalvarFun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarFunActionPerformed(evt);
            }
        });
        painelFuncionario.add(btnSalvarFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 250, -1, -1));

        btnLocalizarCpfFun.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLocalizarCpfFun.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/localizar2.png"))); // NOI18N
        btnLocalizarCpfFun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizarCpfFunActionPerformed(evt);
            }
        });
        painelFuncionario.add(btnLocalizarCpfFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 120, 20, 20));

        btnIncluirFun.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnIncluirFun.setText("Incluir Funcionário");
        btnIncluirFun.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirFunActionPerformed(evt);
            }
        });
        painelFuncionario.add(btnIncluirFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 80, -1, -1));

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel43.setText("Senha:");
        painelFuncionario.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 200, -1, -1));

        grupoBotaoFuncionario.add(radioNaoFun);
        radioNaoFun.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioNaoFun.setText("NÃO");
        painelFuncionario.add(radioNaoFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 200, -1, -1));

        grupoBotaoFuncionario.add(radioSimFun);
        radioSimFun.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioSimFun.setText("SIM");
        painelFuncionario.add(radioSimFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 200, -1, -1));

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel45.setText("Endereço:");
        painelFuncionario.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, -1, -1));

        txtTelefoneFun.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelFuncionario.add(txtTelefoneFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 160, 130, -1));

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel46.setText("Login:");
        painelFuncionario.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, -1, -1));

        txtSenhaFun.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtSenhaFun.setText("123456");
        painelFuncionario.add(txtSenhaFun, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 200, 140, -1));

        jTabbedPane1.addTab("Funcionário", painelFuncionario);

        painelMorador.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel8.setText("Morador");
        painelMorador.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel34.setText("Lista de Moradores");
        painelMorador.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));

        jTableMorador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableMorador.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Cpf do morador", "Nome do morador", "Telefone do morador", "Email do morador", "Código do Apartamento", "Bloco do Prédio", "Número do Apartamento"
            }
        ));
        jTableMorador.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMoradorMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(jTableMorador);

        painelMorador.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 1080, 170));

        btnConsultarMorador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnConsultarMorador.setText("Consultar Morador");
        btnConsultarMorador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarMoradorActionPerformed(evt);
            }
        });
        painelMorador.add(btnConsultarMorador, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        btnIncluirMorador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnIncluirMorador.setText("Incluir Morador");
        btnIncluirMorador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirMoradorActionPerformed(evt);
            }
        });
        painelMorador.add(btnIncluirMorador, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 80, -1, -1));

        btnLimparMorador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLimparMorador.setText("Limpar Campos");
        btnLimparMorador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparMoradorActionPerformed(evt);
            }
        });
        painelMorador.add(btnLimparMorador, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 230, -1, -1));

        btnSalvarMorador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalvarMorador.setText("Salvar");
        btnSalvarMorador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarMoradorActionPerformed(evt);
            }
        });
        painelMorador.add(btnSalvarMorador, new org.netbeans.lib.awtextra.AbsoluteConstraints(1050, 280, -1, -1));

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel48.setText("Nome do Morador:");
        painelMorador.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 130, -1, -1));

        txtNomeMorador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelMorador.add(txtNomeMorador, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 130, 330, -1));

        btnLocalizarNomeMorador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLocalizarNomeMorador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/localizar2_d.png"))); // NOI18N
        btnLocalizarNomeMorador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizarNomeMoradorActionPerformed(evt);
            }
        });
        painelMorador.add(btnLocalizarNomeMorador, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 130, 20, 20));

        jLabel54.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel54.setText("E-mail:");
        painelMorador.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 180, -1, -1));

        txtEmailMorador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelMorador.add(txtEmailMorador, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 180, 210, -1));

        btnLocalizarCpfMorador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLocalizarCpfMorador.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/localizar2_d.png"))); // NOI18N
        btnLocalizarCpfMorador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizarCpfMoradorActionPerformed(evt);
            }
        });
        painelMorador.add(btnLocalizarCpfMorador, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 130, 20, 20));

        btnExcluirMorador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExcluirMorador.setText("Excluir Morador");
        btnExcluirMorador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirMoradorActionPerformed(evt);
            }
        });
        painelMorador.add(btnExcluirMorador, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 230, -1, -1));

        jLabel55.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel55.setText("CPF do Morador:");
        painelMorador.add(jLabel55, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        txtCpfMorador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelMorador.add(txtCpfMorador, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 130, 130, -1));

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel61.setText("Número do Apartamento:");
        painelMorador.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 180, -1, -1));

        txtNumeroApartamentoMorador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelMorador.add(txtNumeroApartamentoMorador, new org.netbeans.lib.awtextra.AbsoluteConstraints(990, 180, 130, -1));

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel62.setText("Ainda mora no Apartamento?");
        painelMorador.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 130, -1, -1));

        grupoBotaoMorador.add(radioSimMorador);
        radioSimMorador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioSimMorador.setText("SIM");
        painelMorador.add(radioSimMorador, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 130, -1, -1));

        grupoBotaoMorador.add(radioNaoMorador);
        radioNaoMorador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        radioNaoMorador.setText("NÃO");
        painelMorador.add(radioNaoMorador, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 130, -1, -1));

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel63.setText("Telefone:");
        painelMorador.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        txtTelefoneMorador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelMorador.add(txtTelefoneMorador, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 130, -1));

        jLabel64.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel64.setText("Bloco do Apartamento:");
        painelMorador.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, -1, -1));

        txtBlocoApartamentoMorador.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelMorador.add(txtBlocoApartamentoMorador, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 180, 130, -1));

        jTabbedPane1.addTab("Morador", painelMorador);

        painelVisita.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Visita");
        painelVisita.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Lista de Visitante Incluído na Visita");
        painelVisita.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 220, -1, -1));

        tabelaVisitanteNaVisita.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelaVisitanteNaVisita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "CPF do Visitante", "Nome do Visitante"
            }
        ));
        jScrollPane1.setViewportView(tabelaVisitanteNaVisita);

        painelVisita.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 240, 410, 100));

        btnIncluirVisita.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnIncluirVisita.setText("Incluir Nova Visita");
        btnIncluirVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirVisitaActionPerformed(evt);
            }
        });
        painelVisita.add(btnIncluirVisita, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel65.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel65.setText("Hora da Visita:");
        painelVisita.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        txtHoraVisita.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelVisita.add(txtHoraVisita, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, 100, -1));

        btnLocalizarNomeMoradorVisita.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLocalizarNomeMoradorVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/localizar2_d.png"))); // NOI18N
        painelVisita.add(btnLocalizarNomeMoradorVisita, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 460, 20, 20));

        btnLimparVisita.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLimparVisita.setText("Limpar Campos");
        btnLimparVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparVisitaActionPerformed(evt);
            }
        });
        painelVisita.add(btnLimparVisita, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 500, -1, -1));

        btnExcluirVisita.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExcluirVisita.setText("Excluir Visita");
        painelVisita.add(btnExcluirVisita, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 500, -1, -1));

        btnExcluirVisitanteLista.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExcluirVisitanteLista.setText("Excluir Visitante da Lista");
        btnExcluirVisitanteLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirVisitanteListaActionPerformed(evt);
            }
        });
        painelVisita.add(btnExcluirVisitanteLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 310, 180, -1));

        jLabel66.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel66.setText("Telefone do morador:");
        painelVisita.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 410, -1, -1));

        txtTelefoneMoradorVisita.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelVisita.add(txtTelefoneMoradorVisita, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 410, 140, -1));

        jLabel67.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel67.setText("Data da Visita:");
        painelVisita.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        txtDataVisita.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelVisita.add(txtDataVisita, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 100, -1));

        jTableHistoricoVisita.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableHistoricoVisita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Cód. da Visita", "Data da Visita", "Hora da Visita", "CPF Morador", "CPF Visitante"
            }
        ));
        jScrollPane7.setViewportView(jTableHistoricoVisita);

        painelVisita.add(jScrollPane7, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 880, 100));

        tabelaMoradorVisita.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelaMoradorVisita.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "CPF do Morador", "Nome do Morador"
            }
        ));
        jScrollPane8.setViewportView(tabelaMoradorVisita);

        painelVisita.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 390, 410, 90));

        jLabel69.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel69.setText("CPF do Visitante:");
        painelVisita.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        txtCpfMoradorVisita.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelVisita.add(txtCpfMoradorVisita, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 410, 130, -1));

        jLabel70.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel70.setText("Nome do Visitante:");
        painelVisita.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, -1, -1));

        txtNomeVisitanteVisita.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelVisita.add(txtNomeVisitanteVisita, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, 330, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Histórico das Visitas");
        painelVisita.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, -1, -1));

        jLabel71.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel71.setText("CPF do Morador a ser visitado:");
        painelVisita.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 410, -1, -1));

        txtCpfVisitanteVisita.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelVisita.add(txtCpfVisitanteVisita, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, 110, -1));

        btnLocalizarCpfVisitanteVisita.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLocalizarCpfVisitanteVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/localizar2_d.png"))); // NOI18N
        painelVisita.add(btnLocalizarCpfVisitanteVisita, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 20, 20));

        jLabel72.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel72.setText("Nome do Morador:");
        painelVisita.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 460, -1, -1));

        txtNomeMoradorVisita.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelVisita.add(txtNomeMoradorVisita, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 460, 180, -1));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Lista de Moradores");
        painelVisita.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 370, -1, -1));

        btnSalvarVisita.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalvarVisita.setText("Salvar");
        btnSalvarVisita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarVisitaActionPerformed(evt);
            }
        });
        painelVisita.add(btnSalvarVisita, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 500, -1, -1));

        btnLocalizarCpfMoradorVisita.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLocalizarCpfMoradorVisita.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/localizar2_d.png"))); // NOI18N
        painelVisita.add(btnLocalizarCpfMoradorVisita, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 410, 20, 20));

        btnIncluirVisitanteLista.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnIncluirVisitanteLista.setText("Incluir Visitante na Lista");
        btnIncluirVisitanteLista.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirVisitanteListaActionPerformed(evt);
            }
        });
        painelVisita.add(btnIncluirVisitanteLista, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 260, 180, -1));
        painelVisita.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, 1100, 10));
        painelVisita.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, 1100, 10));

        jLabel3.setText("Informações do Morador");
        painelVisita.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        jLabel4.setText("Informações do visitante");
        painelVisita.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 210, -1, -1));

        jTabbedPane1.addTab("Visita", painelVisita);

        painelVisitante.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        painelVisitante.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, -1, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Visitante");
        painelVisitante.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Lista de Visitante");
        painelVisitante.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, 320, -1));

        jTableVisitante.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableVisitante.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Cpf", "Nome"
            }
        ));
        jScrollPane6.setViewportView(jTableVisitante);

        painelVisitante.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 1100, 260));

        btnLimparVisitante.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLimparVisitante.setText("Limpar Campos");
        btnLimparVisitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparVisitanteActionPerformed(evt);
            }
        });
        painelVisitante.add(btnLimparVisitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 120, -1, -1));

        btnExcluirVisitante.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExcluirVisitante.setText("Excluir Visitante");
        painelVisitante.add(btnExcluirVisitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 480, -1, -1));

        btnSalvarVisitante.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalvarVisitante.setText("Salvar");
        btnSalvarVisitante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarVisitanteActionPerformed(evt);
            }
        });
        painelVisitante.add(btnSalvarVisitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 480, -1, -1));

        jLabel73.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel73.setText("CPF do Visitante:");
        painelVisitante.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        txtCpfVisitante.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelVisitante.add(txtCpfVisitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 130, -1));

        btnLocalizarCpfVisitante.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLocalizarCpfVisitante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/localizar2_d.png"))); // NOI18N
        painelVisitante.add(btnLocalizarCpfVisitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 120, 20, 20));

        jLabel74.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel74.setText("Nome do Visitante:");
        painelVisitante.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 120, -1, -1));

        txtNomeVisitante.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelVisitante.add(txtNomeVisitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 120, 450, -1));

        btnLocalizarNomeVisitante.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLocalizarNomeVisitante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/localizar2_d.png"))); // NOI18N
        painelVisitante.add(btnLocalizarNomeVisitante, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 120, 20, 20));

        jTabbedPane1.addTab("Visitante", painelVisitante);

        painelApartamento.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel10.setText("Apartamento");
        painelApartamento.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

        jTableApartamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableApartamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Código do Apartamento", "Bloco do Prédio", "Nº do Apartamento", "Estacionamento 1", "Estacionamento 2"
            }
        ));
        jTableApartamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableApartamentoMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTableApartamento);

        painelApartamento.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 1100, 210));

        btnConsultarApartamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnConsultarApartamento.setText("Consultar Apartamento");
        btnConsultarApartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarApartamentoActionPerformed(evt);
            }
        });
        painelApartamento.add(btnConsultarApartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        btnIncluirApartamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnIncluirApartamento.setText("Incluir Apartamento");
        btnIncluirApartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirApartamentoActionPerformed(evt);
            }
        });
        painelApartamento.add(btnIncluirApartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, -1, -1));

        jLabel75.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel75.setText("Lista de Apartamento");
        painelApartamento.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 260, -1, -1));

        txtCodApartamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelApartamento.add(txtCodApartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 130, 190, -1));

        btnLocalizarCodApartamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLocalizarCodApartamento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/localizar2_d.png"))); // NOI18N
        btnLocalizarCodApartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocalizarCodApartamentoActionPerformed(evt);
            }
        });
        painelApartamento.add(btnLocalizarCodApartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 130, 20, 20));

        btnLimparApartamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLimparApartamento.setText("Limpar Campos");
        btnLimparApartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparApartamentoActionPerformed(evt);
            }
        });
        painelApartamento.add(btnLimparApartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 180, -1, -1));

        btnExcluirApartamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExcluirApartamento.setText("Excluir Apartamento");
        btnExcluirApartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirApartamentoActionPerformed(evt);
            }
        });
        painelApartamento.add(btnExcluirApartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 230, -1, -1));

        btnSalvarApartamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalvarApartamento.setText("Salvar");
        btnSalvarApartamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarApartamentoActionPerformed(evt);
            }
        });
        painelApartamento.add(btnSalvarApartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 230, -1, -1));

        jLabel76.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel76.setText("Bloco do Apartamento:");
        painelApartamento.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 130, -1, -1));

        txtBlocoApartamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelApartamento.add(txtBlocoApartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 130, 190, -1));

        jLabel77.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel77.setText("Número do Apartamento:");
        painelApartamento.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 130, -1, -1));

        txtNumeroApartamento.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelApartamento.add(txtNumeroApartamento, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 130, 170, -1));

        jLabel78.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel78.setText("Vaga de Estacionamento 1:");
        painelApartamento.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        txtEstacionamento1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelApartamento.add(txtEstacionamento1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 180, 130, -1));

        jLabel79.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel79.setText("Vaga de Estacionamento 2:");
        painelApartamento.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, -1, -1));

        txtEstacionamento2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelApartamento.add(txtEstacionamento2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, 130, -1));

        jLabel89.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel89.setText("Código do Apartamento:");
        painelApartamento.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, -1));

        jTabbedPane1.addTab("Apartamento", painelApartamento);

        painelVeiculo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel11.setText("Veículo");
        painelVeiculo.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

        jTableVeiculo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTableVeiculo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Placa", "Fabricante", "Modelo", "Cor", "Bloco do Apartamento", "Número do Apartamento"
            }
        ));
        jScrollPane5.setViewportView(jTableVeiculo);

        painelVeiculo.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, 1110, 150));

        btnConsultarVeiculo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnConsultarVeiculo.setText("Consultar Veículo");
        btnConsultarVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarVeiculoActionPerformed(evt);
            }
        });
        painelVeiculo.add(btnConsultarVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        btnIncluirVeiculo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnIncluirVeiculo.setText("Incluir Veículo");
        btnIncluirVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIncluirVeiculoActionPerformed(evt);
            }
        });
        painelVeiculo.add(btnIncluirVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 80, -1, -1));

        jLabel80.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel80.setText("Placa do Veículo:");
        painelVeiculo.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, -1, -1));

        txtPlacaVeiculo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelVeiculo.add(txtPlacaVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 110, -1));

        btnLocalizarPlacaVeiculo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLocalizarPlacaVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/localizar2_d.png"))); // NOI18N
        painelVeiculo.add(btnLocalizarPlacaVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, 20, 20));

        btnLimparVeiculo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLimparVeiculo.setText("Limpar Campos");
        btnLimparVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparVeiculoActionPerformed(evt);
            }
        });
        painelVeiculo.add(btnLimparVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 270, -1, -1));

        btnExcluirVeiculo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnExcluirVeiculo.setText("Excluir Veículo");
        painelVeiculo.add(btnExcluirVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 270, -1, -1));

        btnSalvarVeiculo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnSalvarVeiculo.setText("Salvar");
        btnSalvarVeiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarVeiculoActionPerformed(evt);
            }
        });
        painelVeiculo.add(btnSalvarVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1070, 270, -1, -1));

        btnAlterarFun10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAlterarFun10.setText("Atualizar Lista de Veículo");
        painelVeiculo.add(btnAlterarFun10, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 610, -1, -1));

        jLabel81.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel81.setText("Modelo do Veículo:");
        painelVeiculo.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 120, -1, -1));

        txtModeloVeiculo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelVeiculo.add(txtModeloVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 120, 160, -1));

        jLabel82.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel82.setText("Fabricante do Veículo:");
        painelVeiculo.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 120, -1, -1));

        txtFabricanteVeiculo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelVeiculo.add(txtFabricanteVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 120, 170, -1));

        jLabel83.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel83.setText("Cor do Veículo:");
        painelVeiculo.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, -1, -1));

        txtCorVeiculo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelVeiculo.add(txtCorVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, 130, -1));

        jLabel84.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel84.setText("CPF do Morador:");
        painelVeiculo.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        txtCpfMoradorVeiculo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelVeiculo.add(txtCpfMoradorVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 170, 130, -1));

        jLabel85.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel85.setText("Nome do Morador:");
        painelVeiculo.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 170, -1, -1));

        txtNomeMoradorVeiculo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelVeiculo.add(txtNomeMoradorVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 450, -1));

        jLabel86.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel86.setText("Lista de Veículos");
        painelVeiculo.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 330, -1));

        txtBlocoApartamentoVeiculo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelVeiculo.add(txtBlocoApartamentoVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 270, 130, -1));

        jLabel87.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel87.setText("Número do Apartamento:");
        painelVeiculo.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 270, -1, -1));

        txtNumeroApartamentoVeiculo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        painelVeiculo.add(txtNumeroApartamentoVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, 130, -1));

        jLabel88.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel88.setText("Dados da vaga de Estacionamento:");
        painelVeiculo.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, -1));

        btnLocalizarCpfMoradorVeiculo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnLocalizarCpfMoradorVeiculo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagem/localizar2_d.png"))); // NOI18N
        painelVeiculo.add(btnLocalizarCpfMoradorVeiculo, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 170, 20, 20));

        jLabel90.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel90.setText("Bloco do Apartamento:");
        painelVeiculo.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, -1, -1));

        jTabbedPane1.addTab("Veículo", painelVeiculo);

        jPanel11.setBackground(new java.awt.Color(102, 102, 102));

        lblMsg.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMsg.setForeground(new java.awt.Color(255, 255, 255));
        lblMsg.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblMsg.setText("Mensagem");

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMsg, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1366, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        setSize(new java.awt.Dimension(1382, 729));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSairActionPerformed

        System.exit(0);
    }//GEN-LAST:event_btnSairActionPerformed


    private void btnConsultarFunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarFunActionPerformed

        salvar = "Alterar";
        grupoBotaoFuncionario.clearSelection();
        statusConsultarFuncionario(true);
        limparFuncionario();
    }//GEN-LAST:event_btnConsultarFunActionPerformed

    private void btnLimparFunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparFunActionPerformed

        limparFuncionario();
        statusInicioFuncionario(true);
        salvar = "";
    }//GEN-LAST:event_btnLimparFunActionPerformed

    private void btnSalvarFunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarFunActionPerformed

        setFuncionario();
        String msg;
        boolean status = funcionario.verificaCampoVazio(funcionario);

        if (status == false) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.", "Campo vazio",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            Funcionario funcionarioExistente = new Funcionario();
            funcionarioExistente = dadosCondominio.consultaCpfFuncionario(txtCpfFun.getText());

//--------------------------Incluir------------------------            
            if (salvar.equals("Incluir")) {
                setFuncionario();
                if (funcionarioExistente == null) {
                    if (funcionario.validaCPF(funcionario) == "ok") {
                        if (funcionario.validaNome(funcionario) == true) {
                            if (funcionario.validaTelefone(funcionario) == "ok") {
                                if (JOptionPane.showConfirmDialog(this, "Deseja incluir o Funcionário?",
                                        "Incluir Funcionário", JOptionPane.YES_NO_OPTION) == 0) {
                                    msg = dadosCondominio.insereFuncionario(funcionario);
                                    JOptionPane.showMessageDialog(this, msg, "Incluir Funcionário", JOptionPane.INFORMATION_MESSAGE);
                                    limparFuncionario();
                                    statusInicioFuncionario(true);
                                    exibeGridFuncionario(dadosCondominio.consultaGeralFuncionario());
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, funcionario.validaTelefone(funcionario),
                                        "Telefone inválido", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Por favor digite o nome corretamente",
                                    "Nome incorreto", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, funcionario.validaCPF(funcionario),
                                "CPF inválido", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Digite outro CPF", "CPF digitado já existe!", JOptionPane.ERROR_MESSAGE);
                    txtCpfFun.setText("");
                }

//--------------------------Alterar------------------------                
            } else if (salvar.equals("Alterar")) {
                setFuncionario();
                funcionario.setCod_Fun(Integer.parseInt(txtCodFun.getText()));
                int codFun = funcionario.getCod_Fun(), codFunE = funcionarioExistente.getCod_Fun();

                //-----------------Verifica CPF--------------                
                if (funcionarioExistente == null || funcionarioExistente.getCod_Fun()
                        == funcionario.getCod_Fun()) {
                    if (funcionario.validaCPF(funcionario).equals("ok")) {
                        if (funcionario.validaNome(funcionario) == true) {
                            if (funcionario.validaTelefone(funcionario) == "ok") {
                                if (JOptionPane.showConfirmDialog(this, "Deseja alterar os dados do Funcionario?",
                                        "Alterar dados", JOptionPane.YES_NO_OPTION) == 0) {
                                    setFuncionario();
                                    msg = dadosCondominio.alteraFuncionario(funcionario);
                                    JOptionPane.showMessageDialog(this, msg, "Alterar dados", JOptionPane.INFORMATION_MESSAGE);

                                    limparFuncionario();
                                    statusInicioFuncionario(true);
                                    exibeGridFuncionario(dadosCondominio.consultaGeralFuncionario());
                                }
                            } else {
                                JOptionPane.showMessageDialog(this, funcionario.validaTelefone(funcionario),
                                        "Telefone inválido", JOptionPane.ERROR_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Por favor digite o nome corretamente",
                                    "Nome incorreto", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, funcionario.validaCPF(funcionario),
                                "CPF inválido", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Digite outro CPF", "CPF digitado já existe", JOptionPane.ERROR_MESSAGE);
                    txtCpfFun.setText("");
                }
            }
        }
    }//GEN-LAST:event_btnSalvarFunActionPerformed

    private void btnIncluirFunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirFunActionPerformed

        salvar = "Incluir";
        grupoBotaoFuncionario.clearSelection();
        statusIncluirFuncionario(true);
        limparFuncionario();
    }//GEN-LAST:event_btnIncluirFunActionPerformed

    private void btnConsultarMoradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarMoradorActionPerformed

        salvar = "Alterar";
        grupoBotaoMorador.clearSelection();
        statusConsultarMorador(true);
        limparMorador();
    }//GEN-LAST:event_btnConsultarMoradorActionPerformed

    private void btnIncluirMoradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirMoradorActionPerformed

        salvar = "Incluir";
        grupoBotaoMorador.clearSelection();
        statusIncluirMorador(true);
        limparMorador();
    }//GEN-LAST:event_btnIncluirMoradorActionPerformed

    private void btnLimparMoradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparMoradorActionPerformed

        limparMorador();
        statusInicioMorador(true);
    }//GEN-LAST:event_btnLimparMoradorActionPerformed

    private void btnSalvarMoradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarMoradorActionPerformed

        setMorador();
        String msg;
        boolean statusCampoVazio = morador.verificaCampoVazio(morador);
        String cpfValido = dadosCondominio.validaCpf(morador.getCpfMorador());
        String verificaNumeroCpf = dadosCondominio.validaNumero(morador.getCpfMorador(), 20);
        Apartamento existeApartamento = dadosCondominio.verificaExisteApartamento(
                morador.getBlocoApartamentoMorador(), Integer.parseInt(morador.getNumeroApartamentoMorador()));

        if (existeApartamento != null) {
            int codigoApartamento = existeApartamento.getCodigoApartamento();

            if (statusCampoVazio != false) {
                if (verificaNumeroCpf.equals("Numero")) {
                    if (cpfValido.equals("Ok")) {
                        if (dadosCondominio.validaNome(morador.getNomeMorador()) == true) {

//--------------------------Inserir Morador------------------------
                            if (salvar.equals("Incluir")) {
                                if (JOptionPane.showConfirmDialog(this, "Deseja incluir o Morador?",
                                        "Incluir Morador", JOptionPane.YES_NO_OPTION) == 0) {
                                    msg = dadosCondominio.insereMorador(morador, codigoApartamento);
                                    JOptionPane.showMessageDialog(this, msg, "Incluir Morador", JOptionPane.INFORMATION_MESSAGE);
                                    limparMorador();
                                    statusInicioMorador(true);
                                    exibeGridMorador(dadosCondominio.consultaGeralMorador());
                                }

//--------------------------Alterar Morador------------------------
                            } else if (salvar.equals("Alterar")) {
                                if (JOptionPane.showConfirmDialog(this, "Deseja alterar os dados do Morador?",
                                        "Alterar dados", JOptionPane.YES_NO_OPTION) == 0) {
                                    setMorador();
                                    msg = dadosCondominio.alteraMorador(morador, codigoApartamento);
                                    JOptionPane.showMessageDialog(this, msg, "Alterar dados", JOptionPane.INFORMATION_MESSAGE);

                                    limparMorador();
                                    statusInicioMorador(true);
                                    exibeGridMorador(dadosCondominio.consultaGeralMorador());
                                }
                            }
                        } else {
                            JOptionPane.showMessageDialog(this, "Digite corretamente o nome.",
                                    "Nome Incorreto", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, cpfValido,
                                "CPF Incorreto", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Digite apenas numeros, sem ponto.",
                            "CPF Inválido", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.",
                        "Campo vazio", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Apartamento " + morador.getNumeroApartamentoMorador() +
                    ", Bloco " + morador.getBlocoApartamentoMorador() + " não existe.",
                    "Apartamento não cadastrado", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSalvarMoradorActionPerformed

    private void btnIncluirVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirVisitaActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_btnIncluirVisitaActionPerformed

    private void btnLimparVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparVisitaActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimparVisitaActionPerformed

    private void btnExcluirVisitanteListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirVisitanteListaActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_btnExcluirVisitanteListaActionPerformed

    private void btnSalvarVisitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarVisitaActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarVisitaActionPerformed

    private void btnLimparVisitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparVisitanteActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimparVisitanteActionPerformed

    private void btnSalvarVisitanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarVisitanteActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarVisitanteActionPerformed

    private void btnConsultarApartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarApartamentoActionPerformed

        salvar = "Alterar";
        statusConsultarApartamento(true);
        limparApartamento();
    }//GEN-LAST:event_btnConsultarApartamentoActionPerformed

    private void btnIncluirApartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirApartamentoActionPerformed

        salvar = "Incluir";
        limparApartamento();
        statusIncluirApartamento(true);
    }//GEN-LAST:event_btnIncluirApartamentoActionPerformed

    private void btnLimparApartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparApartamentoActionPerformed

        limparApartamento();
        statusInicioApartamento(true);
    }//GEN-LAST:event_btnLimparApartamentoActionPerformed

    private void btnSalvarApartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarApartamentoActionPerformed

        setApartamento();
        String msg, bloco = apartamento.getBlocoApartamento();
        int numAp = Integer.parseInt(apartamento.getNumeroApartamento());
        boolean status = apartamento.verificaCampoVazioApartamento(apartamento);

        if (status == false) {
            JOptionPane.showMessageDialog(this, "Por favor, preencha todos os campos.", "Campo vazio",
                    JOptionPane.ERROR_MESSAGE);
        } else {
            if (apartamento.validaNumeroApartamento(apartamento) == true) {
                if (dadosCondominio.verificaExisteApartamento(bloco, numAp) == null) {

//--------------------------Incluir Apartamento------------------------                    
                    if (salvar.equals("Incluir")) {
                        setApartamento();
                        if (JOptionPane.showConfirmDialog(this, "Deseja Incluir o Apartamento?",
                                "Incluir Apartamento", JOptionPane.YES_NO_OPTION) == 0) {
                            msg = dadosCondominio.insereApartamento(apartamento);
                            JOptionPane.showMessageDialog(this, msg, "Incluir Apartamento", JOptionPane.INFORMATION_MESSAGE);
                            limparApartamento();
                            statusInicioApartamento(true);
                            exibeGridApartamento(dadosCondominio.consultaGeralApartamento());
                        }

//--------------------------Alterar Apartamento------------------------                         
                    } else if (salvar.equals("Alterar")) {
                        setApartamento();
                        apartamento.setCodigoAparatamento(Integer.parseInt(txtCodApartamento.getText()));

                        if (JOptionPane.showConfirmDialog(this, "Deseja alterar os dados do Apartamento?",
                                "Alterar dados", JOptionPane.YES_NO_OPTION) == 0) {
                            setApartamento();
                            msg = dadosCondominio.alterarApartamento(apartamento);
                            JOptionPane.showMessageDialog(this, msg, "Alterar dados",
                                    JOptionPane.INFORMATION_MESSAGE);

                            limparApartamento();
                            statusInicioApartamento(true);
                            exibeGridApartamento(dadosCondominio.consultaGeralApartamento());
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Digite outro número para o bloco do apartamento",
                            "Apartamento já cadastrado!", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Digite apenas números maior que zero no campo do número do apartamento",
                        "Número invalido!", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnSalvarApartamentoActionPerformed

    private void btnConsultarVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarVeiculoActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultarVeiculoActionPerformed

    private void btnIncluirVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirVeiculoActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_btnIncluirVeiculoActionPerformed

    private void btnLimparVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparVeiculoActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_btnLimparVeiculoActionPerformed

    private void btnSalvarVeiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarVeiculoActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_btnSalvarVeiculoActionPerformed

    private void btnLocalizarCodFunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarCodFunActionPerformed

        salvar = "Alterar";
        statusConsultarFuncionario(true);
        System.out.println("valida ----> " + dadosCondominio.validaNumero(txtCodFun.getText(), 10));

        if (dadosCondominio.validaNumero(txtCodFun.getText(), 10) == "Numero") {
            funcionario = dadosCondominio.consultaCodigoFuncionario(Integer.parseInt(txtCodFun.getText()));
            if (funcionario == null) {
                JOptionPane.showMessageDialog(this, "Código não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                statusInicioFuncionario(true);
                limparFuncionario();
            } else {
                getFuncionario();
                statusAlterarFuncionario(true);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Digite apenas números!", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btnLocalizarCodFunActionPerformed

    private void btnLogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLogoutActionPerformed

        Login login = new Login();
        login.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnLogoutActionPerformed

    private void btnLocalizarCpfFunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarCpfFunActionPerformed

        salvar = "Alterar";
        statusAlterarFuncionario(true);
        String cpf = txtCpfFun.getText();
        funcionario = dadosCondominio.consultaCpfFuncionario(cpf);
        if (funcionario == null) {
            JOptionPane.showMessageDialog(this, "Funcionário não encontrado", "CPF não cadastrado",
                    JOptionPane.ERROR_MESSAGE);
            statusInicioFuncionario(true);
            limparFuncionario();
        } else {
            getFuncionario();
            statusAlterarFuncionario(true);
        }
    }//GEN-LAST:event_btnLocalizarCpfFunActionPerformed

    private void jTableFuncionarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableFuncionarioMouseClicked

        salvar = "Alterar";
        statusAlterarFuncionario(true);
        int posicao = jTableFuncionario.getSelectedRow();
        String ativo = (String) jTableFuncionario.getValueAt(posicao, 6);
        funcionario = dadosCondominio.consultaCpfFuncionario(String.valueOf(jTableFuncionario.getValueAt(posicao, 1)));
        getFuncionario();
    }//GEN-LAST:event_jTableFuncionarioMouseClicked

    private void btnExcluirFunActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirFunActionPerformed

        if (JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o funcionário "
                + txtNomeFun.getText() + " do banco de dados?", "Excluir Funcionário",
                JOptionPane.YES_NO_OPTION) == 0) {
            String codigo = txtCodFun.getText();
            dadosCondominio.excluiFuncionario(codigo);
            exibeGridFuncionario(dadosCondominio.consultaGeralFuncionario());
            limparFuncionario();
        }
    }//GEN-LAST:event_btnExcluirFunActionPerformed

    private void btnLocalizarCodApartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarCodApartamentoActionPerformed

        salvar = "Alterar";
        statusAlterarApartamento(true);
        String codApart = dadosCondominio.validaNumero(txtCodApartamento.getText(), 10);

        if (codApart == "Numero") {
            apartamento = dadosCondominio.consultaCodigoApartamento(Integer.parseInt(txtCodApartamento.getText()));
            if (apartamento == null) {
                JOptionPane.showMessageDialog(this, "Código não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
                statusInicioApartamento(true);
                limparApartamento();
            } else {
                getApartamento();
                statusAlterarApartamento(true);
                System.out.println("2" + apartamento.getCodigoApartamento());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Digite apenas número!", "Erro", JOptionPane.ERROR_MESSAGE);
            limparApartamento();
        }
    }//GEN-LAST:event_btnLocalizarCodApartamentoActionPerformed

    private void btnLocalizarCpfMoradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarCpfMoradorActionPerformed

        salvar = "Alterar";
        statusAlterarMorador(true);
        String cpf = txtCpfMorador.getText();
        morador = dadosCondominio.consultaCpfMorador(cpf);

        if (dadosCondominio.validaCpf(cpf).equals("Ok")) {
            if(morador != null) {
                getMorador(morador);
                statusAlterarMorador(true);
            } else {
                JOptionPane.showMessageDialog(this, "Morador não encontrado", "CPF não cadastrado",
                        JOptionPane.ERROR_MESSAGE);
                statusConsultarMorador(true);
                limparMorador();
            }
        } else {
            statusConsultarMorador(true);
            limparMorador();
            JOptionPane.showMessageDialog(this, "Digite apenas números com 11 dígitos, sem ponto", "CPF inválido",
                    JOptionPane.ERROR_MESSAGE);
            
        }
//        if (!dadosCondominio.validaCpf(cpf).equals("Ok")) {
//            if (morador == null) {
//                JOptionPane.showMessageDialog(this, "Morador não encontrado", "CPF não cadastrado",
//                        JOptionPane.ERROR_MESSAGE);
//                statusInicioMorador(true);
//                limparMorador();
//            } else {
//                getMorador();
//                statusAlterarMorador(true);
//            }
//        } else {
//            JOptionPane.showMessageDialog(this, "Digite apenas números com 11 dígitos, sem ponto", "CPF inválido",
//                    JOptionPane.ERROR_MESSAGE);
//            statusAlterarMorador(true);
//            limparMorador();
//        }

    }//GEN-LAST:event_btnLocalizarCpfMoradorActionPerformed

    private void btnLocalizarNomeMoradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocalizarNomeMoradorActionPerformed

        statusAlterarMorador(true);
    }//GEN-LAST:event_btnLocalizarNomeMoradorActionPerformed

    private void btnIncluirVisitanteListaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIncluirVisitanteListaActionPerformed

    }//GEN-LAST:event_btnIncluirVisitanteListaActionPerformed

    private void jTableApartamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableApartamentoMouseClicked

        salvar = "Alterar";
        statusAlterarApartamento(true);
        int posicao = jTableApartamento.getSelectedRow();
        apartamento = dadosCondominio.consultaCodigoApartamento(Integer.parseInt(jTableApartamento.getValueAt(posicao, 0).toString()));
        getApartamento();
    }//GEN-LAST:event_jTableApartamentoMouseClicked

    private void btnExcluirApartamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirApartamentoActionPerformed

        if (JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o apartamento "
                + txtNumeroApartamento.getText() + " do bloco " + txtBlocoApartamento.getText()
                + " do banco de dados?", "Excluir Funcionário",
                JOptionPane.YES_NO_OPTION) == 0) {
            String codigo = txtCodApartamento.getText();
            dadosCondominio.excluiApartamento(codigo);
            exibeGridApartamento(dadosCondominio.consultaGeralApartamento());
            limparApartamento();
        }
    }//GEN-LAST:event_btnExcluirApartamentoActionPerformed

    private void jTableMoradorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMoradorMouseClicked
        salvar = "Alterar";
        statusAlterarMorador(true);
        int posicao = jTableMorador.getSelectedRow();
        morador = dadosCondominio.consultaCpfMorador(String.valueOf(jTableMorador.getValueAt(posicao, 0)));
        getMorador(morador);    }//GEN-LAST:event_jTableMoradorMouseClicked

    private void btnExcluirMoradorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirMoradorActionPerformed
        if (JOptionPane.showConfirmDialog(this, "Deseja realmente excluir o Morador "
                + txtNomeMorador.getText() + " do banco de dados?", "Excluir Morador",
                JOptionPane.YES_NO_OPTION) == 0) {
            String cpfMorador = txtCpfMorador.getText();
            dadosCondominio.excluiMorador(cpfMorador);
            exibeGridMorador(dadosCondominio.consultaGeralMorador());
            limparMorador();
        }
    }//GEN-LAST:event_btnExcluirMoradorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">

        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.

         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 

         */
        try {

            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {

                if ("Nimbus".equals(info.getName())) {

                    javax.swing.UIManager.setLookAndFeel(info.getClassName());

                    break;

                }

            }

        } catch (ClassNotFoundException ex) {

            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {

            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {

            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {

            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);

        }

        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    //---------------Método do Funcionario---------------
    private void setFuncionario() {

        String ativo;
        if (radioSimFun.isSelected()) {
            ativo = "Sim";
        } else if (radioNaoFun.isSelected()) {
            ativo = "Nao";
        } else {
            ativo = "Vazio";
        }
        funcionario.setCpf(txtCpfFun.getText());
        funcionario.setNome(txtNomeFun.getText());
        funcionario.setCargo(txtCargoFun.getText());
        funcionario.setTelefone(txtTelefoneFun.getText());
        funcionario.setEndereco(txtEnderecoFun.getText());
        funcionario.setAtivo(ativo);
        funcionario.setLogin(txtCpfFun.getText());
        funcionario.setSenha(String.valueOf((txtSenhaFun.getPassword())));
    }

    private void getFuncionario() {

        txtCodFun.setText(String.valueOf(funcionario.getCod_Fun()));
        txtCpfFun.setText(funcionario.getCpf());
        txtNomeFun.setText(funcionario.getNome());
        txtCargoFun.setText(funcionario.getCargo());
        txtTelefoneFun.setText(funcionario.getTelefone());
        txtEnderecoFun.setText(funcionario.getEndereco());
        String ativo = funcionario.getAtivo();
        txtLoginFun.setText(funcionario.getLogin());
        txtSenhaFun.setText(funcionario.getSenha());

        if (ativo.equals("Sim")) {
            radioSimFun.setSelected(true);
        } else if (ativo.equals("Nao")) {
            radioNaoFun.setSelected(true);
        }
    }

    //---------------Método do Apartamento---------------
    private void setApartamento() {
        apartamento.setNumeroApartamento(txtNumeroApartamento.getText());
        apartamento.setBlocoApartamento(txtBlocoApartamento.getText());
        apartamento.setVagaApartamento_1(txtEstacionamento1.getText());
        apartamento.setVagaApartamento_2(txtEstacionamento2.getName());
    }

    private void getApartamento() {
        txtCodApartamento.setText(String.valueOf(apartamento.getCodigoApartamento()));
        txtNumeroApartamento.setText(String.valueOf(apartamento.getNumeroApartamento()));
        txtBlocoApartamento.setText(apartamento.getBlocoApartamento());
        txtEstacionamento1.setText(apartamento.getVagaApartamento_1());
        txtEstacionamento2.setText(apartamento.getVagaApartamento_2());
    }

    //---------------Método do Morador---------------
    private void setMorador() {
        String ativo;

        if (radioSimMorador.isSelected()) {
            ativo = "Sim";
        } else if (radioNaoMorador.isSelected()) {
            ativo = "Nao";
        } else {
            ativo = "Vazio";
        }

        morador.setCpfMorador(txtCpfMorador.getText());
        morador.setNomeMorador(txtNomeMorador.getText());
        morador.setTelefoneMorador(txtTelefoneMorador.getText());
        morador.setEmailMorador(txtEmailMorador.getText());
        morador.setBlocoApartamentoMorador(txtBlocoApartamentoMorador.getText());
        morador.setNumeroApartamentoMorador(txtNumeroApartamentoMorador.getText());
        morador.setAtivoMorador(ativo);
    }

    private void getMorador(Morador morador) {
        String ativo = morador.getAtivoMorador();

        if (ativo.equals("Sim")) {
            radioSimMorador.setSelected(true);
        } else if (ativo.equals("Nao")) {
            radioNaoMorador.setSelected(true);
        }

        Apartamento apart = dadosCondominio.consultaCodigoApartamento(morador.getCodigoMorador());
        
        if(apart != null) {
            txtBlocoApartamentoMorador.setText(apart.getBlocoApartamento());
            txtNumeroApartamentoMorador.setText(apart.getNumeroApartamento());
        }
        
        txtCpfMorador.setText(morador.getCpfMorador());
        txtNomeMorador.setText(morador.getNomeMorador());
        txtTelefoneMorador.setText(morador.getTelefoneMorador());
        txtEmailMorador.setText(morador.getEmailMorador());
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAlterarFun10;
    private javax.swing.JButton btnConsultarApartamento;
    private javax.swing.JButton btnConsultarFun;
    private javax.swing.JButton btnConsultarMorador;
    private javax.swing.JButton btnConsultarVeiculo;
    private javax.swing.JButton btnExcluirApartamento;
    private javax.swing.JButton btnExcluirFun;
    private javax.swing.JButton btnExcluirMorador;
    private javax.swing.JButton btnExcluirVeiculo;
    private javax.swing.JButton btnExcluirVisita;
    private javax.swing.JButton btnExcluirVisitante;
    private javax.swing.JButton btnExcluirVisitanteLista;
    private javax.swing.JButton btnIncluirApartamento;
    private javax.swing.JButton btnIncluirFun;
    private javax.swing.JButton btnIncluirMorador;
    private javax.swing.JButton btnIncluirVeiculo;
    private javax.swing.JButton btnIncluirVisita;
    private javax.swing.JButton btnIncluirVisitanteLista;
    private javax.swing.JButton btnLimparApartamento;
    private javax.swing.JButton btnLimparFun;
    private javax.swing.JButton btnLimparMorador;
    private javax.swing.JButton btnLimparVeiculo;
    private javax.swing.JButton btnLimparVisita;
    private javax.swing.JButton btnLimparVisitante;
    private javax.swing.JButton btnLocalizarCodApartamento;
    private javax.swing.JButton btnLocalizarCodFun;
    private javax.swing.JButton btnLocalizarCpfFun;
    private javax.swing.JButton btnLocalizarCpfMorador;
    private javax.swing.JButton btnLocalizarCpfMoradorVeiculo;
    private javax.swing.JButton btnLocalizarCpfMoradorVisita;
    private javax.swing.JButton btnLocalizarCpfVisitante;
    private javax.swing.JButton btnLocalizarCpfVisitanteVisita;
    private javax.swing.JButton btnLocalizarNomeMorador;
    private javax.swing.JButton btnLocalizarNomeMoradorVisita;
    private javax.swing.JButton btnLocalizarNomeVisitante;
    private javax.swing.JButton btnLocalizarPlacaVeiculo;
    private javax.swing.JButton btnLogout;
    private javax.swing.JButton btnSair;
    private javax.swing.JButton btnSalvarApartamento;
    private javax.swing.JButton btnSalvarFun;
    private javax.swing.JButton btnSalvarMorador;
    private javax.swing.JButton btnSalvarVeiculo;
    private javax.swing.JButton btnSalvarVisita;
    private javax.swing.JButton btnSalvarVisitante;
    private javax.swing.ButtonGroup grupoBotaoFuncionario;
    private javax.swing.ButtonGroup grupoBotaoMorador;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTableApartamento;
    private javax.swing.JTable jTableFuncionario;
    private javax.swing.JTable jTableHistoricoVisita;
    private javax.swing.JTable jTableMorador;
    private javax.swing.JTable jTableVeiculo;
    private javax.swing.JTable jTableVisitante;
    private javax.swing.JLabel lblCargo;
    private javax.swing.JLabel lblMsg;
    private javax.swing.JLabel lblNome_Fun;
    private javax.swing.JPanel painelApartamento;
    private javax.swing.JPanel painelFuncionario;
    private javax.swing.JPanel painelMorador;
    private javax.swing.JPanel painelVeiculo;
    private javax.swing.JPanel painelVisita;
    private javax.swing.JPanel painelVisitante;
    private javax.swing.JRadioButton radioNaoFun;
    private javax.swing.JRadioButton radioNaoMorador;
    private javax.swing.JRadioButton radioSimFun;
    private javax.swing.JRadioButton radioSimMorador;
    private javax.swing.JTable tabelaMoradorVisita;
    private javax.swing.JTable tabelaVisitanteNaVisita;
    private javax.swing.JTextField txtBlocoApartamento;
    private javax.swing.JTextField txtBlocoApartamentoMorador;
    private javax.swing.JTextField txtBlocoApartamentoVeiculo;
    private javax.swing.JTextField txtCargoFun;
    private javax.swing.JTextField txtCodApartamento;
    private javax.swing.JTextField txtCodFun;
    private javax.swing.JTextField txtCorVeiculo;
    private javax.swing.JTextField txtCpfFun;
    private javax.swing.JTextField txtCpfMorador;
    private javax.swing.JTextField txtCpfMoradorVeiculo;
    private javax.swing.JTextField txtCpfMoradorVisita;
    private javax.swing.JTextField txtCpfVisitante;
    private javax.swing.JTextField txtCpfVisitanteVisita;
    private javax.swing.JTextField txtDataVisita;
    private javax.swing.JTextField txtEmailMorador;
    private javax.swing.JTextField txtEnderecoFun;
    private javax.swing.JTextField txtEstacionamento1;
    private javax.swing.JTextField txtEstacionamento2;
    private javax.swing.JTextField txtFabricanteVeiculo;
    private javax.swing.JTextField txtHoraVisita;
    private javax.swing.JTextField txtLoginFun;
    private javax.swing.JTextField txtModeloVeiculo;
    private javax.swing.JTextField txtNomeFun;
    private javax.swing.JTextField txtNomeMorador;
    private javax.swing.JTextField txtNomeMoradorVeiculo;
    private javax.swing.JTextField txtNomeMoradorVisita;
    private javax.swing.JTextField txtNomeVisitante;
    private javax.swing.JTextField txtNomeVisitanteVisita;
    private javax.swing.JTextField txtNumeroApartamento;
    private javax.swing.JTextField txtNumeroApartamentoMorador;
    private javax.swing.JTextField txtNumeroApartamentoVeiculo;
    private javax.swing.JTextField txtPlacaVeiculo;
    private javax.swing.JPasswordField txtSenhaFun;
    private javax.swing.JTextField txtTelefoneFun;
    private javax.swing.JTextField txtTelefoneMorador;
    private javax.swing.JTextField txtTelefoneMoradorVisita;
    // End of variables declaration//GEN-END:variables

}
