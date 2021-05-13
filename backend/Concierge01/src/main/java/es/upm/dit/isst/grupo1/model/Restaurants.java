package es.upm.dit.isst.grupo1.model;


import java.io.Serializable;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name="Restaurants")
public class Restaurants implements Serializable {

		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int id;
		private int numero_usuarios;
		@ManyToOne
		@JoinColumn(name = "cliente", referencedColumnName = "id")
		private Client cliente;
		private String name;
		private String cuisine;
		private String address;
		private String description;
		private String photo;
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
		public String getCuisine() {
			return cuisine;
		}
		public void setCuisine(String cuisine) {
			this.cuisine = cuisine;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getPhoto() {
			return photo;
		}
		public void setPhoto(String photo) {
			this.photo = photo;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		public Restaurants(int id, int numero_usuarios, Client cliente, String name, String cuisine, String address,
				String description, String photo) {
			super();
			this.id = id;
			this.numero_usuarios = numero_usuarios;
			this.cliente = cliente;
			this.name = name;
			this.cuisine = cuisine;
			this.address = address;
			this.description = description;
			this.photo = photo;
		}
		public Restaurants() {
			// TODO Auto-generated constructor stub
		}
		
		
		
		
}		
		
		
