package com.emergentes.dao;
import com.emergentes.utiles.ConexionBD;
import com.emergentes.modelo.Posts;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class PostsDAOimpl extends ConexionBD implements PostsDAO{

    @Override
    public void insert(Posts post) throws Exception {
        try{
            this.Conectar();
            PreparedStatement ps= this.conn.prepareStatement("insert into posts(fecha,titulo,contenido) values(?,?,?)");
            ps.setString(1, post.getFecha());
            ps.setString(2, post.getTitulo());
            ps.setString(3, post.getContenido());
            ps.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.Desconectar();
        }
    }

    @Override
    public void update(Posts post) throws Exception {
        try{
            this.Conectar();
            PreparedStatement ps= this.conn.prepareStatement("update posts set fecha=?, titulo=?, contenido=? where id=?");
            ps.setString(1, post.getFecha());
            ps.setString(2, post.getTitulo());
            ps.setString(3, post.getContenido());
            ps.setInt(4, post.getId());
            ps.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.Desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try{
            this.Conectar();
            PreparedStatement ps= this.conn.prepareStatement("delete from posts where id=?");
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch(Exception e){
            throw e;
        }finally{
            this.Desconectar();
        }
    }

    @Override
    public Posts getById(int id) throws Exception {
        Posts pos=new Posts();
        try{
            this.Conectar();
            PreparedStatement ps= this.conn.prepareStatement("select *from posts where id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                pos.setId(rs.getInt("id"));
                pos.setFecha(rs.getString("fecha"));
                pos.setTitulo(rs.getString("titulo"));
                pos.setContenido(rs.getString("contenido"));
            }
        }catch(Exception e){
            throw e;
        }finally{
            this.Desconectar();
        }
        return pos;
    }

    @Override
    public List<Posts> getAll() throws Exception {
        List<Posts> lista= null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        try{
            this.Conectar();
            PreparedStatement ps= this.conn.prepareStatement("select *from posts order by fecha desc");
            ResultSet rs = ps.executeQuery();
            lista=new ArrayList<Posts>();
            while(rs.next()){
                Posts pos= new Posts();
                pos.setId(rs.getInt("id"));
                pos.setFecha(sdf.format(rs.getDate("fecha")));
                pos.setTitulo(rs.getString("titulo"));
                pos.setContenido(rs.getString("contenido"));
                lista.add(pos);
            }
            rs.close();
            ps.close();
        }catch(Exception e){
            throw e;
        }finally{
            this.Desconectar();
        }
        return lista;
    }   
}
