package es.upm.dit.isst.grupo1.model;


import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity(name="Shows")
public class Shows implements Serializable {

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
		private String info2;
		private String description;
        private String photo1;
        private String photo2;
        private String photo3;
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
		public String getInfo2() {
			return info2;
		}
		public void setInfo2(String info2) {
			this.info2 = info2;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getPhoto1() {
			return photo1;
		}
		public void setPhoto1(String photo1) {
			this.photo1 = photo1;
		}
		public String getPhoto2() {
			return photo2;
		}
		public void setPhoto2(String photo2) {
			this.photo2 = photo2;
		}
		public String getPhoto3() {
			return photo3;
		}
		public void setPhoto3(String photo3) {
			this.photo3 = photo3;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		public Shows(int id, int numero_usuarios, Client cliente, String name, String info, String info2,
				String description, String photo1, String photo2, String photo3) {
			super();
			this.id = id;
			this.numero_usuarios = numero_usuarios;
			this.cliente = cliente;
			this.name = name;
			this.info = info;
			this.info2 = info2;
			this.description = description;
			this.photo1 = photo1;
			this.photo2 = photo2;
			this.photo3 = photo3;
		}
	
        
		
}