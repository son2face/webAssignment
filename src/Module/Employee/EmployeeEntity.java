package Module.Employee;

import Module.File.FileEntity;
import Module.File.FileModel;
import Module.Location.LocationEntity;
import Module.Location.LocationModel;
import Module.Team.TeamEntity;
import Module.Team.TeamModel;
import Module.Ticket.TicketEntity;
import Module.Ticket.TicketModel;
import Module.TicketRead.TicketReadEntity;
import Module.TicketRead.TicketreadModel;
import Module.TicketRelater.TicketRelaterEntity;
import Module.TicketRelater.TicketrelaterModel;
import Module.TicketThread.TicketThreadEntity;
import Module.TicketThread.TicketthreadModel;
import Module.User.UserEntity;
import Module.User.UserModel;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
public class EmployeeEntity implements Serializable {
    public int id;
    public String email;
    public String name;
    public Integer teamId;
    public Integer locationId;
    public String briefName;
    public TeamEntity teamEntity;
    public LocationEntity locationEntity;
    public List<FileEntity> fileEntities;
    public List<LocationEntity> locationEntities;
    public List<TeamEntity> teamEntities;
    public List<TicketEntity> createTicketEntities;
    public List<TicketEntity> assignTicketEntities;
    public List<TicketReadEntity> ticketReadEntities;
    public List<TicketRelaterEntity> ticketRelaterEntities;
    public List<TicketThreadEntity> ticketThreadEntities;
    public List<UserEntity> userEntities;

    public EmployeeEntity() {
    }


    public EmployeeEntity(EmployeeModel EmployeeModel, Object... objects) {
        this.id = EmployeeModel.getId();
        this.email = EmployeeModel.getEmail();
        this.name = EmployeeModel.getName();
        this.teamId = EmployeeModel.getTeamId();
        this.locationId = EmployeeModel.getLocationId();
        this.briefName = EmployeeModel.getBriefName();
        for (Object object : objects) {
            if (object instanceof TeamModel) {
                this.teamEntity = new TeamEntity((TeamModel) object);
            } else if (object instanceof LocationModel) {
                this.locationEntity = new LocationEntity((LocationModel) object);
            } else if (object instanceof Collection) {
                for (Object o : (Collection<Object>) object) {
                    if (o instanceof FileModel) {
                        this.fileEntities = ((Collection<FileModel>) object).parallelStream().map(FileEntity::new).collect(Collectors.toList());
                        break;
                    } else if (o instanceof LocationModel) {
                        this.locationEntities = ((Collection<LocationModel>) object).parallelStream().map(LocationEntity::new).collect(Collectors.toList());
                        break;
                    } else if (o instanceof TeamModel) {
                        this.teamEntities = ((Collection<TeamModel>) object).parallelStream().map(TeamEntity::new).collect(Collectors.toList());
                        break;
                    } else if (o instanceof TicketModel) {
                        this.assignTicketEntities = ((Collection<TicketModel>) object).parallelStream().map(TicketEntity::new).collect(Collectors.toList());
                        break;
                    }else if (o instanceof TicketreadModel) {
                        this.ticketReadEntities = ((Collection<TicketreadModel>) object).parallelStream().map(TicketReadEntity::new).collect(Collectors.toList());
                        break;
                    }else if (o instanceof TicketrelaterModel) {
                        this.ticketRelaterEntities = ((Collection<TicketrelaterModel>) object).parallelStream().map(TicketRelaterEntity::new).collect(Collectors.toList());
                        break;
                    }else if (o instanceof TicketthreadModel) {
                        this.ticketThreadEntities = ((Collection<TicketthreadModel>) object).parallelStream().map(TicketThreadEntity::new).collect(Collectors.toList());
                        break;
                    }else if (o instanceof UserModel) {
                        this.userEntities = ((Collection<UserModel>) object).parallelStream().map(UserEntity::new).collect(Collectors.toList());
                        break;
                    }
                }
            }
        }

    }

    public EmployeeModel toModel() {
        EmployeeModel employeeModel = new EmployeeModel();
        employeeModel.setBriefName(briefName);
        employeeModel.setEmail(email);
        employeeModel.setName(name);
        employeeModel.setId(id);
        employeeModel.setLocationId(locationId);
        employeeModel.setTeamId(teamId);
        return employeeModel;
    }
}
