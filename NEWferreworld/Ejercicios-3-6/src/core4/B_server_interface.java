package core4;

import java.util.ArrayList;

/**
 * @since 05-12-2013
 * @author Kelwin Gamez
 *
 * @param <T> Tipo genérico que representa la ip
 * @param <Cliente> Representa la clase donde se almacenaran los cliente
 * que se conectarán al servidor
 */
public interface B_server_interface <T,Cliente>{

	/**
	 * Envía la fecha actual a un cliente
	 * @param ipDestino Dirección IP a donde se quiere enviar la fecha
	 */
	public void enviarFecha(T ipDestino);
	
	/**
	 * Conecta un cliente
	 * @param ip IP asociada al cliente
	 * @return <code>true</code> si se pudo conectar <false> en caso
	 * contrario
	 */
	public boolean conectarCliente(T ip);
	
	/**
	 * Desconecta un cliente del servidor de tiempo
	 * @param ip IP asociada al cliente
	 * @return <code>true</code> si se pudo conectar <false> en caso
	 */
	public boolean desconectarCliente(T ip);
	
	/**
	 * Enviar hora al cliente
	 * @param ip IP asociada al cliente
	 */
	public void enviarHora(T ip);
	
	/**
	 * @return Lista los clientes que se encuentra conectado al servidor
	 */
	public ArrayList<Cliente> listarClientes();
	
}
