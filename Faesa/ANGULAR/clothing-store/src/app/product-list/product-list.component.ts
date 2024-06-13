import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.scss'],
  standalone: true,
  imports: [CommonModule]
})
export class ProductListComponent {
  products = [
    { nome: 'Camiseta', descricao: 'Camiseta confortável para uso diário', preco: 19.99, imagem: '../assets/camiseta.jpg' },
    { nome: 'Calça Jeans', descricao: 'Calça jeans moderna e elegante', preco: 39.99, imagem: '../assets/calcajeans.jpg' },
    { nome: 'Jaqueta', descricao: 'Jaqueta resistente para o inverno', preco: 79.99, imagem: '../assets/jaqueta.jpg' },
    { nome: 'Tênis', descricao: 'Tênis esportivo para qualquer ocasião', preco: 49.99, imagem: '../assets/tenis.jpg' },
    { nome: 'Vestido', descricao: 'Vestido elegante para eventos especiais', preco: 99.99, imagem: '../assets/vestido.jpg' }
  ];
}


