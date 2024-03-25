package com.lucasangelo.todosimple.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lucasangelo.todosimple.models.User;
// import com.lucasangelo.todosimple.repositories.TaskRepository;
import com.lucasangelo.todosimple.repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    // @Autowired
        // obs: taskRepository esta comentado pq nao será salvo a task e o usuario de uma vez só
    // private TaskRepository taskRepository;


    public User findById(Long id){
        Optional<User> user = this.userRepository.findById(id);
        return user.orElseThrow(() -> new RuntimeException(
            "Usuario não encontrado! Id: "+ id +", Tipo: "+User.class.getName()
        ));
    }

    @Transactional
    public User create(User obj){
        obj.setId(null);
        obj = this.userRepository.save(obj);
        // this.taskRepository.saveAll(obj.getTasks());
        return obj;
    }

    @Transactional
    public User update(User obj){
        User newObj = findById(obj.getId());
        newObj.setPassword(obj.getPassword());
        return this.userRepository.save(newObj);
    }

    @Transactional
    public void delete(Long id){
        findById(id);
        try {
            this.userRepository.deleteById(id);
        } catch (Exception e) {
           throw new RuntimeException("Não é possivel excluir pois a dados relacionados a este usuario!");
        }
    }
}
