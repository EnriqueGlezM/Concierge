package es.upm.dit.isst.grupo1.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name="Shopping")
public class Shopping implements Serializable {

		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int id;
		private int numero_usuarios;
		@ManyToOne
		@JoinColumn(name = "cliente", referencedColumnName = "id")
		private Client cliente;
		private String name;
		private Double price;
		private Double hotelPoints;
		private String photo;
		private Integer quantity;
		private String category;
				
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public int getNumero_usuarios() {
			return numero_usuarios;
		}
		public void setNumero_usuarios(int numero_usuarios) {
			this.numero_usuarios = numero_usuarios;
		}
		public Client getCliente() {
			return cliente;
		}
		public void setCliente(Client cliente) {
			this.cliente = cliente;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Double getPrice() {
			return price;
		}
		public void setPrice(Double price) {
			this.price = price;
		}
		public Double getHotelPoints() {
			return hotelPoints;
		}
		public void setHotelPoints(Double hotelPoints) {
			this.hotelPoints = hotelPoints;
		}
		public String getPhoto() {
			return photo;
		}
		public void setPhoto(String photo) {
			this.photo = photo;
		}
		public Integer getQuantity() {
			return quantity;
		}
		public void setQuantity(Integer quantity) {
			this.quantity = quantity;
		}
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		public Shopping(int id, int numero_usuarios, Client cliente, String name, Double price, Double hotelPoints,
				String photo, Integer quantity, String category) {
			super();
			this.id = id;
			this.numero_usuarios = numero_usuarios;
			this.cliente = cliente;
			this.name = name;
			this.price = price;
			this.hotelPoints = hotelPoints;
			this.photo = photo;
			this.quantity = quantity;
			this.category = category;
		}
		public Shopping() {
			// TODO Auto-generated constructor stub
		}
		
		
}