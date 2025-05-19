package org.example.service;

import org.example.model.Usuario;

import java.util.Scanner;

public class MenuLogin {

    private static final Scanner scanner = new Scanner(System.in);
    private static final Catalogo catalogo = new Catalogo();
    private static final GerenciarPlaylists gerenciarPlaylists = new GerenciarPlaylists();
    private static final Cadastro cadastro = new Cadastro();
    protected static Usuario usuarioLogado = null;


    public static void mostrarMenu() {
        int opcao;

        do {
            System.out.println("\n====== MENU PRINCIPAL ======");
            System.out.println("1. Cadastrar usuário");
            System.out.println("2. Login");
            System.out.println("0. Fechar programa");

            opcao = lerInteiro("Escolha uma opção: ");

            switch (opcao) {
                case 1 -> cadastrarUsuario();
                case 2 -> login();
                case 0 -> System.out.println("Saindo...");
                default -> System.out.println("Opção inválida.");
            }

        } while (opcao != 0);
    }

    private static void cadastrarUsuario() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("E-mail: ");
        String email = scanner.nextLine();

        Usuario novoUsuario = new Usuario(nome, email);

        if (!cadastro.getUsuarios().contains(novoUsuario)) {

            cadastro.cadastrarUsuario(novoUsuario);
            MenuLogin.usuarioLogado = novoUsuario;
            System.out.println("Usuário cadastrado e logado com sucesso. Bem vindo " + novoUsuario.getNome() + "!");
            verificarLogin();
        } else {
            System.out.println("Usuario já cadastrado");
        }
    }

    private static void login() {

        if(cadastro.getUsuarios().isEmpty()) {
            System.out.println("Nenhum usuário cadastrado");
            cadastrarUsuario();
        }

        System.out.print("Digite seu e-mail: ");
        String email = scanner.nextLine();

        MenuLogin.usuarioLogado = cadastro.getUsuarios().stream()
                .filter(u -> u.getEmail().equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);

        if (MenuLogin.usuarioLogado != null) {
            System.out.println("Login realizado com sucesso. Bem-vindo, " + usuarioLogado.getNome() + "!");
            verificarLogin();
        } else {
            System.out.println("Usuário não encontrado.");
            login();
        }
    }

    private static int lerInteiro(String mensagem) {
        int valor = -1;
        boolean valido = false;

        while (!valido) {
            try {
                System.out.print(mensagem);
                valor = Integer.parseInt(scanner.nextLine());
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número inteiro.");
            }
        }

        return valor;
    }

    private static void verificarLogin() {
        if (MenuLogin.usuarioLogado == null) {
            System.out.println("Você precisa estar logado.");
            login();
        }else {
            Menu.mostrarMenu();
        }
    }

    public static Usuario getUsuarioLogado() {
        return MenuLogin.usuarioLogado;
    }
}
