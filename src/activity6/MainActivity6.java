package activity6;

import java.sql.SQLException;

public class MainActivity6 {

	public static void main(String[] args) throws SQLException {

		QuerySQL query = new QuerySQL("actividad6_T18", "root", "7INs3!h09L%d");
		
		//Create tables

		query.query(
				"create table piezas(" + "codigo int not null," + "nombre nvarchar(100)," + "primary key(codigo))");

		query.query(
				"create table proveedores(" + "id char(4) not null," + "nombre nvarchar(100)," + "primary key(id))");

		query.query("create table suministra(" + "codigopiezas int not null," + "idproveedor char(4) not null,"
				+ "precio int," + "primary key(codigopiezas,idproveedor)," + "key(codigopiezas),"
				+ "foreign key(codigopiezas)" + "references piezas(codigo)," + "key(idproveedor),"
				+ "foreign key(idproveedor)" + "references proveedores(id))");
		
		//Insert values

		query.query("INSERT INTO piezas VALUE " + "(1,'Pieza1')," + "(2,'Pieza2')," + "(3,'Pieza3'),"
				+ "(4,'Pieza4')," + "(5,'Pieza5')," + "(6,'Pieza6')," + "(7,'Pieza7')," + "(8,'Pieza8'),"
				+ "(9,'Pieza9')," + "(10,'Pieza10')");

		query.query("INSERT INTO proveedores VALUE" + "('000A','Proveedor1')," + "('000B','Proveedor2'),"
				+ "('000C','Proveedor3')," + "('000D','Proveedor4')," + "('000E','Proveedor5'),"
				+ "('000F','Proveedor6')," + "('000G','Proveedor7')," + "('000H','Proveedor8'),"
				+ "('000I','Proveedor9')," + "('000J','Proveedor10')");

		query.query("INSERT INTO suministra VALUE" + "(1,'000A',50)," + "(1,'000B',30)," + "(2,'000C',70),"
				+ "(2,'000D',30)," + "(3,'000E',70)," + "(3,'000F',60)," + "(4,'000F',30)," + "(4,'000H',20),"
				+ "(5,'000I',50)," + "(5,'000J',20)");

	}

}
