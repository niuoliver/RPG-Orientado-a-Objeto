package rpg;

import javax.swing.*;
import java.awt.*;

public class TelaNpc extends JFrame {
        
    private JTextArea areaInformacoes;
    private JButton btnDidi, btnSerjao, btnNobre, btnVendedor, btnArmeiro, btnTaberneiro, btnPersonagens;
    private fase fase;
    private npc didi, serjao;
    private nobre haddad;
    private armeiro thomas;
    private vendedor da_luz;
    private taberneiro zeca;
    private personagem p1, p2, p3, p4;

    public TelaNpc(fase bar, npc didi, npc serjao, nobre haddad, armeiro thomas, vendedor da_luz, taberneiro zeca
    , personagem p1, personagem p2, personagem p3, personagem p4){
        this.fase = bar;
        this.didi = didi;
        this.serjao = serjao;
        this.haddad = haddad;
        this.thomas = thomas;
        this.da_luz = da_luz;
        this.zeca = zeca;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;

        setTitle("Informações Bar do Zeca.");
        setSize(600, 500);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Painel de informações", JLabel.CENTER);
        titulo.setFont(new Font("Serif", Font.BOLD, 24));
        add(titulo, BorderLayout.NORTH);

        areaInformacoes = new JTextArea();
        areaInformacoes.setEditable(false);
        areaInformacoes.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane(areaInformacoes);
        add(scroll, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(1, 5, 10, 10));

        btnDidi = new JButton("Didi");
        btnSerjao = new JButton("Serjão");
        btnNobre = new JButton("Nobre");
        btnArmeiro = new JButton("Armeiro");
        btnVendedor = new JButton("Vendedor");
        btnTaberneiro = new JButton("Taberneiro");
        btnPersonagens = new JButton("Personagens");

        painelBotoes.add(btnDidi);
        painelBotoes.add(btnSerjao);
        painelBotoes.add(btnNobre);
        painelBotoes.add(btnArmeiro);
        painelBotoes.add(btnVendedor);
        painelBotoes.add(btnTaberneiro);
        painelBotoes.add(btnPersonagens);
        

        add(painelBotoes, BorderLayout.SOUTH);

        eventos();

        setVisible(true);
    }

    private void eventos(){
        btnDidi.addActionListener(e -> exibirDidi());
        btnSerjao.addActionListener(e -> exibirSerjao());
        btnNobre.addActionListener(e -> exibirNobre());
        btnArmeiro.addActionListener(e -> exibirArmeiro());
        btnVendedor.addActionListener(e -> exibirVendedor());
        btnTaberneiro.addActionListener(e -> exibirTaberneiro());
        btnPersonagens.addActionListener(e -> exibirPersonagnes());
    }

    private void exibirDidi(){
        areaInformacoes.setText(
            "=====DIDI=====\n" + 
            "Nome:" + didi.get_nome() + "\n" + 
            "Informações:" + didi.get_descricao() + "\n" +
            "===============\n" 
        );
    }

    private void exibirSerjao(){
        areaInformacoes.setText(
            "=====SERJÃO=====\n" + 
            "Nome:" + serjao.get_nome() + "\n" + 
            "Informações:" + serjao.get_descricao() + "\n" +
            "================\n"
        );
    }

    private void exibirNobre(){
        areaInformacoes.setText(
            "=====HADDAD=====\n" + 
            "Nome:" + haddad.get_nome() + "\n" + 
            "Informações:" + haddad.get_descricao() + "\n" + 
            "================\n"
        );
    }

    private void exibirArmeiro(){
        areaInformacoes.setText(
            "=====THOMAS=====\n" + 
            "Nome:" + thomas.get_nome() + "\n" + 
            "Informações:" + thomas.get_descricao() + "\n" +
            "================\n"
        );
    }

    private void exibirVendedor(){
        areaInformacoes.setText(
            "=====CABO DA LUZ=====\n" + 
            "Nome:" + da_luz.get_nome() + "\n" + 
            "Informaçõe:" + da_luz.get_descricao() + "\n" +
            "================\n"
        );
    }

    private void exibirTaberneiro(){
        areaInformacoes.setText(
            "=====ZECA=====\n" + 
            "Nome:" + zeca.get_nome() + "\n" + 
            "Informações:" + zeca.get_descricao() + "\n" +
            "================\n"
        );
    }

    private void exibirPersonagnes(){
        areaInformacoes.setText(
            "=====PERSONAGENS=====\n" +
            "Local: " + fase.get_nome() + "\n" + 
            p1.get_nome() + ", dinheiro: " + p1.get_dinheiro() + "\n" +
            p2.get_nome() + ", dinheiro: " + p2.get_dinheiro() + "\n" +
            p3.get_nome() + ", dinheiro: " + p3.get_dinheiro() + "\n" +
            p4.get_nome() + ", dinheiro: " + p4.get_dinheiro() + "\n" 
        );
    }
        
}
