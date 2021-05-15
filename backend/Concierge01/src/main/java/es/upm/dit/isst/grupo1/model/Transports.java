package es.upm.dit.isst.grupo1.model;


import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name="Transports")
public class Transports implements Serializable {

		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private int id;
		private int numero_usuarios;
		@ManyToOne
		@JoinColumn(name = "cliente", referencedColumnName = "id")
		private Client cliente;
		private String name;
		private String info;
		private String description;
        private ArrayList<String> photos;
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
		public String getInfo() {
			return info;
		}
		public void setInfo(String info) {
			this.info = info;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public ArrayList<String> getPhotos() {
			return photos;
		}
		public void setPhotos(ArrayList<String> photos) {
			this.photos = photos;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		public Transports(int id, int numero_usuarios, Client cliente, String name, String info, String description,
				ArrayList<String> photos) {
			super();
			this.id = id;
			this.numero_usuarios = numero_usuarios;
			this.cliente = cliente;
			this.name = name;
			this.info = info;
			this.description = description;
			this.photos = photos;
		}
		public Transports() {
		}       	
}