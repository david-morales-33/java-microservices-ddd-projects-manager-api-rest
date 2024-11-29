package com.dmx.app;

import com.dmx.administrative.post.domain.Post;
import com.dmx.administrative.post.domain.PostDTO;
import com.dmx.administrative.role.domain.Role;
import com.dmx.administrative.role.domain.RoleDTO;
import com.dmx.administrative.space.domain.Space;
import com.dmx.administrative.space.domain.SpaceDTO;
import com.dmx.administrative.team.domain.Team;
import com.dmx.administrative.team.domain.TeamDTO;
import com.dmx.administrative.user.domain.User;
import com.dmx.administrative.user.domain.UserDTO;
import com.dmx.shared.domain.RoleId;

import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        RoleDTO roleDTO1 = new RoleDTO("0c2bd3b0-7469-4a58-b31a-50e4e3cb6479", "Front-end", "Desarrollador");
        RoleDTO roleDTO2 = new RoleDTO("0c2bd3b0-7469-4a58-b31a-50e4e3cb6480", "Back-end", "Desarrollador");
        RoleDTO roleDTO3 = new RoleDTO("0c2bd3b0-7469-4a58-b31a-50e4e3cb6487", "Cliente", "Mujer Latina");

        Role role1 = Role.fromPrimitives(roleDTO1);
        Role role2 = Role.fromPrimitives(roleDTO1);
        Role role3 = Role.fromPrimitives(roleDTO1);

        HashMap<String, RoleDTO> roles1 = new HashMap<>();
        HashMap<String, RoleDTO> roles2 = new HashMap<>();
        HashMap<String, RoleDTO> roles3 = new HashMap<>();

        roles1.put(roleDTO1.id(), roleDTO1);
        roles1.put(roleDTO2.id(), roleDTO2);
        roles2.put(roleDTO2.id(), roleDTO2);
        roles3.put(roleDTO3.id(), roleDTO3);

        UserDTO userDTO1 = new UserDTO("0c2bd3b0-7469-4a58-b31a-50e4e3cb9654", "David Morales", "morales33.2014@gmail.com", "morales33.2014", roles1);
        UserDTO userDTO2 = new UserDTO("0c2bd3b0-7469-4a58-b31a-50e4e3cb9656", "Luis Villa", "luis998.12@gmail.com", "villa_998_12", roles2);
        UserDTO userDTO3 = new UserDTO("0c2bd3b0-7469-4a58-b31a-50e4e3cb9786", "Marcela Lopez", "marcela32.10@gmail.com", "marcela32", roles3);

        User user1 = User.fromPrimitives(userDTO1);
        User user2 = User.fromPrimitives(userDTO2);
        User user3 = User.fromPrimitives(userDTO3);

        PostDTO postDTO1 = new PostDTO("0c2bd3b0-7469-4a58-b31a-50e4e3cb1456", "title 1", "Texto 1", "24-11-2024", "0c2bd3b0-7469-4a58-b31a-50e4e3cb0978", userDTO1);
        PostDTO postDTO2 = new PostDTO("0c2bd3b0-7469-4a58-b31a-50e4e3cb1457", "title 2", "Texto 2", "25-11-2024", "0c2bd3b0-7469-4a58-b31a-50e4e3cb0978", userDTO1);
        PostDTO postDTO3 = new PostDTO("0c2bd3b0-7469-4a58-b31a-50e4e3cb1458", "title 3", "Texto 3", "26-11-2024", "0c2bd3b0-7469-4a58-b31a-50e4e3cb0978", userDTO2);
        PostDTO postDTO4 = new PostDTO("0c2bd3b0-7469-4a58-b31a-50e4e3cb1459", "title 4", "Texto 4", "27-11-2024", "0c2bd3b0-7469-4a58-b31a-50e4e3cb0978", userDTO2);
        PostDTO postDTO5 = new PostDTO("0c2bd3b0-7469-4a58-b31a-50e4e3cb1460", "title 5", "Texto 5", "28-11-2024", "0c2bd3b0-7469-4a58-b31a-50e4e3cb0978", userDTO3);

        Post post1 = Post.fromPrimitives(postDTO1);
        Post post2 = Post.fromPrimitives(postDTO2);
        Post post3 = Post.fromPrimitives(postDTO3);
        Post post4 = Post.fromPrimitives(postDTO4);
        Post post5 = Post.fromPrimitives(postDTO5);

        HashMap<String, PostDTO> postList = new HashMap<>();
        HashSet<String> teamMembers = new HashSet<String>();

        SpaceDTO spaceDTO1 = new SpaceDTO(
                "0c2bd3b0-7469-4a58-b31a-50e4e3cb0978",
                "Crear usuarios",
                "24-11-2024",
                "0c2bd3b0-7469-4a58-b31a-50e4e3cb6771",
                postList,
                teamMembers,
                0,
                0
        );
        SpaceDTO spaceDTO2 = new SpaceDTO(
                "0c2bd3b0-7469-4a58-b31a-50e4e3cb0945",
                "Actualizar usuarios",
                "24-11-2024",
                "0c2bd3b0-7469-4a58-b31a-50e4e3cb6771",
                postList,
                teamMembers,
                0,
                0
        );
        Space space1 = Space.fromPrimitive(spaceDTO1);
        Space space2 = Space.fromPrimitive(spaceDTO2);

        HashSet<String> spaceMembers = new HashSet<>();
        HashMap<String, SpaceDTO> spaceList = new HashMap<>();

        TeamDTO teamDTO = new TeamDTO(
                "0c2bd3b0-7469-4a58-b31a-50e4e3cb1444",
                "Desarrollo de auntenticacion",
                10,
                1,
                "24-11-2024",
                true,
                roleDTO1,
                spaceMembers,
                spaceList
        );

        Team team = Team.fromPrimitives(teamDTO);
        space1.addMember(post1.getUser().getId());
        space2.addMember(post5.getUser().getId());
        team.addSpace(space1);
        team.addSpace(space2);
        team.addUser(post1.getUser().getId());
        team.addUser(post5.getUser().getId());
        team.addPost(post1);

        System.out.println(team.toPrimitives());
    }
}