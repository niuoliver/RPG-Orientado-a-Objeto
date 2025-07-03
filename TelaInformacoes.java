package rpg;

import javax.swing.*;
import java.awt.*;

public class TelaInformacoes extends JFrame {

    private JTextArea areaInformacoes;
    private JButton btnPersonagem, btnFase, btnInimigo, btnLoot, btnSair;
    private personagem personagem;
    private fase fase;
    private inimigo inimigo;
    private loot loot;

    public TelaInformacoes(personagem personagem, fase fase, inimigo inimigo, loot loot) {
        this.personagem = personagem;
        this.fase = fase;
        this.inimigo = inimigo;
        this.loot = loot;

        setTitle("Informações do Jogo");
        setSize(600, 500);
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JLabel titulo = new JLabel("Painel de Informações", JLabel.CENTER);
        titulo.setFont(new Font("Serif", Font.BOLD, 24));
        add(titulo, BorderLayout.NORTH);

        areaInformacoes = new JTextArea();
        areaInformacoes.setEditable(false);
        areaInformacoes.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scroll = new JScrollPane(areaInformacoes);
        add(scroll, BorderLayout.CENTER);

        JPanel painelBotoes = new JPanel();
        painelBotoes.setLayout(new GridLayout(1, 5, 10, 10));

        btnPersonagem = new JButton("Personagem");
        btnFase = new JButton("Fase");
        btnInimigo = new JButton("Inimigo");
        btnLoot = new JButton("Loot");
        btnSair = new JButton("Sair");

        painelBotoes.add(btnPersonagem);
        painelBotoes.add(btnFase);
        painelBotoes.add(btnInimigo);
        painelBotoes.add(btnLoot);
        painelBotoes.add(btnSair);

        add(painelBotoes, BorderLayout.SOUTH);

        eventos();

        setVisible(true);
    }

    private void eventos() {
        btnPersonagem.addActionListener(e -> exibirPersonagem());
        btnFase.addActionListener(e -> exibirFase());
        btnInimigo.addActionListener(e -> exibirInimigo());
        btnLoot.addActionListener(e -> exibirLoot());
        btnSair.addActionListener(e -> {
            int resp = JOptionPane.showConfirmDialog(this, "Deseja sair?", "Sair", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        });
    }

    private void exibirPersonagem() {
        areaInformacoes.setText(
            "===== PERSONAGEM =====\n" +
            "Nome: " + personagem.get_nome() + "\n" +
            "Vida: " + personagem.get_hp() + "\n" +
            "Ataque: " + personagem.get_ataque() + "\n" +
            "Defesa: " + personagem.get_defesa() + "\n" +
            "Dinheiro: " + personagem.get_dinheiro() + "\n" +
            "=======================\n"
        );
    }

    private void exibirFase() {
        areaInformacoes.setText(
            "===== FASE =====\n" +
            "Nome da Fase: " + fase.get_nome() + "\n" +
            "Dificuldade: " + fase.get_dificuldade() + "\n" +
            "Descrição: " + fase.get_descricao() + "\n" +
            "================\n"
        );
    }

    private void exibirInimigo() {
        areaInformacoes.setText(
            "===== INIMIGO =====\n" +
            "Nome: " + inimigo.get_nome() + "\n" +
            "Vida: " + inimigo.get_hp() + "\n" +
            "Ataque: " + inimigo.get_dano() + "\n" +
            "Defesa: " + inimigo.get_defesa() + "\n" +
            "====================\n"
        );
    }

    private void exibirLoot() {
        areaInformacoes.setText(
            "===== LOOT =====\n" +
            "Item: " + loot.get_nome() + "\n" +
            "Tipo: " + loot.get_tipo() + "\n" +
            "Valor: " + loot.get_valor() + "\n" +
            "================\n"
        );
    }
}

