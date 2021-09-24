package com.natymorgs.backEndSpring;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.natymorgs.backEndSpring.domain.Categoria;
import com.natymorgs.backEndSpring.domain.Cidade;
import com.natymorgs.backEndSpring.domain.Cliente;
import com.natymorgs.backEndSpring.domain.Endereco;
import com.natymorgs.backEndSpring.domain.Estado;
import com.natymorgs.backEndSpring.domain.ItemPedido;
import com.natymorgs.backEndSpring.domain.Pagamento;
import com.natymorgs.backEndSpring.domain.PagamentoComBoleto;
import com.natymorgs.backEndSpring.domain.PagamentoComCartao;
import com.natymorgs.backEndSpring.domain.Pedido;
import com.natymorgs.backEndSpring.domain.Produto;
import com.natymorgs.backEndSpring.domain.enums.EstadoPagamento;
import com.natymorgs.backEndSpring.domain.enums.TipoCliente;
import com.natymorgs.backEndSpring.repositories.CategoriaRepository;
import com.natymorgs.backEndSpring.repositories.CidadeRepository;
import com.natymorgs.backEndSpring.repositories.ClienteRepository;
import com.natymorgs.backEndSpring.repositories.EnderecoRepository;
import com.natymorgs.backEndSpring.repositories.EstadoRepository;
import com.natymorgs.backEndSpring.repositories.ItemPedidoRepository;
import com.natymorgs.backEndSpring.repositories.PagamentoRepository;
import com.natymorgs.backEndSpring.repositories.PedidoRepository;
import com.natymorgs.backEndSpring.repositories.ProdutoRepository;

@SpringBootApplication
public class BackEndSpringApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtorepository;
	
	@Autowired
	private EstadoRepository estadorepository;
	
	@Autowired
	private CidadeRepository cidaderepository;
	
	@Autowired
	private ClienteRepository clienterepository;
	
	@Autowired
	private EnderecoRepository enderecorepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	ItemPedidoRepository itemPedidoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(BackEndSpringApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null, "Computador", 2000.00);
		Produto p2 = new Produto(null, "Impressora", 800.00);
		Produto p3 = new Produto(null, "Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat2.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		produtorepository.saveAll(Arrays.asList(p1, p2, p3));
		
		Estado est1 =new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est1.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadorepository.saveAll(Arrays.asList(est1, est2));
		cidaderepository.saveAll(Arrays.asList(c1, c2, c3));
		
		Cliente cli1 = new Cliente(null, "Maria", "maria@hotmail.com", "232232323233",TipoCliente.PESSOAFISICA);
		
		cli1.getTelefones().addAll(Arrays.asList("1231321313", "1123412341234"));
		
		Endereco e1 = new Endereco(null, "Rua teste", "12", "casa", "Centro", "37750000", cli1, c1);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1));
		
		clienterepository.saveAll(Arrays.asList(cli1));
		
		enderecorepository.saveAll(Arrays.asList(e1));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Pedido ped1 = new Pedido(null, sdf.parse("30/09/2021 10:32"), cli1, e1);
		Pedido ped2 = new Pedido(null, sdf.parse("30/10/2021 19:32"), cli1, e1);
		
		Pagamento pgt1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pgt1);
		Pagamento pgt2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2,sdf.parse("20/10/2021 19:40"), null);
		ped2.setPagamento(pgt2);
		
		cli1.getPedidos().addAll(Arrays.asList(ped1, ped2));
		
		pedidoRepository.saveAll(Arrays.asList(ped1, ped2));
		
		pagamentoRepository.saveAll(Arrays.asList(pgt1, pgt2));
		
		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 2000.00);
		ItemPedido ip2 = new ItemPedido(ped1, p3, 0.00, 2, 80.00);
		
		ped1.getItems().addAll(Arrays.asList(ip1, ip2));
		
		p1.getItems().addAll(Arrays.asList(ip1));
		p2.getItems().addAll(Arrays.asList(ip2));
		
		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip2));
		
	}

}
