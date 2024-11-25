package com.dmx.app;

import com.dmx.administrative.post.domain.PostDTO;
import com.dmx.administrative.role.domain.Role;
import com.dmx.administrative.role.domain.RoleDTO;
import com.dmx.administrative.space.domain.Space;
import com.dmx.administrative.space.domain.SpaceDTO;
import com.dmx.administrative.team.domain.Team;
import com.dmx.administrative.team.domain.TeamDTO;
import com.dmx.administrative.user.domain.UserDTO;
import com.dmx.shared.domain.RoleId;

import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {

        RoleDTO roleDTO1 = new RoleDTO("0c2bd3b0-7469-4a58-b31a-50e4e3cb6479", "Front-end", "Desarrollador");
        RoleDTO roleDTO2 = new RoleDTO("0c2bd3b0-7469-4a58-b31a-50e4e3cb6480", "Back-end", "Desarrollador");
        RoleDTO roleDTO3 = new RoleDTO("0c2bd3b0-7469-4a58-b31a-50e4e3cb6487", "Cliente", "Mujer Latina");

        UserDTO userDTO1 = new UserDTO("0c2bd3b0-7469-4a58-b31a-50e4e3cb9654", "David Morales", "morales33.2014@gmail.com", "morales33.2014", roleDTO1);
        UserDTO userDTO2 = new UserDTO("0c2bd3b0-7469-4a58-b31a-50e4e3cb9656", "Luis Villa", "luis998.12@gmail.com", "villa_998_12", roleDTO2);
        UserDTO userDTO3 = new UserDTO("0c2bd3b0-7469-4a58-b31a-50e4e3cb9786", "Marcela Lopez", "marcela32.10@gmail.com", "marcela32", roleDTO3);

        PostDTO postDTO1 = new PostDTO("0c2bd3b0-7469-4a58-b31a-50e4e3cb1456","Botones inicio","Tengo error con los botones de inicio","24-11-2024","0c2bd3b0-7469-4a58-b31a-50e4e3cb0978", userDTO1);

        PostDTO postDTO2 = new PostDTO("0c2bd3b0-7469-4a58-b31a-50e4e3cb1457","Botones inicio","Esto es lo que no me funciona","24-11-2024","0c2bd3b0-7469-4a58-b31a-50e4e3cb0978", userDTO1);

        PostDTO postDTO3 = new PostDTO("0c2bd3b0-7469-4a58-b31a-50e4e3cb1458","Botones inicio","Ya me dioooooo","24-11-2024","0c2bd3b0-7469-4a58-b31a-50e4e3cb0978", userDTO1);

        String[] postList = new String[0];
        String[] memberList = new String[0];

        SpaceDTO spaceDTO1 = new SpaceDTO("0c2bd3b0-7469-4a58-b31a-50e4e3cb6667","Crear usuarios","24-11-2024","0c2bd3b0-7469-4a58-b31a-50e4e3cb6771",postList, memberList);

        HashSet<String> membersList = new HashSet<>();
        membersList.add(userDTO1.id());
        membersList.add(userDTO2.id());
        membersList.add(userDTO3.id());

        HashMap<String, SpaceDTO> spaceList = new HashMap<>();
        spaceList.put(spaceDTO1.id(),spaceDTO1);

        TeamDTO teamDTO = new TeamDTO(
                "0c2bd3b0-7469-4a58-b31a-50e4e3cb1444",
                "Desarrollo de auntenticacion",
                10,
                1,
                "24-11-2024",
                true,
                roleDTO1,
                membersList,
                spaceList
        );
        Team team = Team.fromPrimitives(teamDTO);
        System.out.println(team.toPrimitives());
    }
}