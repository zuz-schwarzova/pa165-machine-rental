package cz.muni.fi.pa165.machrent.service;

import cz.muni.fi.pa165.machrent.MachineService;
import cz.muni.fi.pa165.machrent.MachineServiceImpl;
import cz.muni.fi.pa165.machrent.config.ServiceConfiguration;
import cz.muni.fi.pa165.machrent.dao.MachineDao;
import cz.muni.fi.pa165.machrent.dto.MachineCreateDto;
import cz.muni.fi.pa165.machrent.entities.Machine;
import cz.muni.fi.pa165.machrent.exception.MachrentDataAccesException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.mockito.Mockito.when;
import cz.muni.fi.pa165.machrent.BeanMappingService;
import cz.muni.fi.pa165.machrent.BeanMappingServiceImpl;
import cz.muni.fi.pa165.machrent.MachineService;
import cz.muni.fi.pa165.machrent.config.ServiceConfiguration;
import cz.muni.fi.pa165.machrent.dto.MachineCreateDto;
import cz.muni.fi.pa165.machrent.dto.MachineDto;
import cz.muni.fi.pa165.machrent.entities.Machine;
import org.mockito.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTransactionalTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.crypto.Mac;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
import static org.testng.AssertJUnit.*;

/**
 * Created by zuz-schwarzova on 23. 11. 2016.
 */
@ContextConfiguration (classes = ServiceConfiguration.class)
@TestExecutionListeners(TransactionalTestExecutionListener.class)
@Transactional
public class MachineServiceTest extends AbstractTestNGSpringContextTests {

    @Mock
    private MachineDao machineDao;

    @Autowired
    @InjectMocks
    private MachineService machineService = new MachineServiceImpl();

    @Captor
    private ArgumentCaptor<Machine> machineArgumentCaptor;

    private Machine machine1;
    private Machine machine2;
    private String name1;
    private String name2;
    private String description1;
    private String description2;

    @BeforeClass
    public void initMockito(){
        MockitoAnnotations.initMocks(this);
    }

    @BeforeMethod
    public void initMachines(){
        machine1 = new Machine();
        machine2 = new Machine();
        name1="mach1";
        name2="mach2";
        description1 = "lala";
        description2 = "salala";
        machine1.setId(1L);
        machine1.setName(name1);
        machine1.setDescription(description1);
        machine2.setId(2L);
        machine2.setName(name2);
        machine2.setDescription(description2);
    }

    @BeforeMethod(dependsOnMethods = "initMachines")
    public void initMocksBehaviour(){
        //find by id
        when(machineService.findById(1L)).thenReturn(machine1);
        when(machineService.findById(2L)).thenReturn(machine2);
    }

    @Test
    public void create(){
        machineService.createMachine(machine1);
        verify(machineDao).create(machine1);
    }

    @Test
    public void update() {
        machineService.updateMachine(machine1);
        verify(machineDao).update(machine1);
    }

    @Test
    public void delete(){
        machineService.deleteMachine(machine1);
        verify(machineDao).delete(machine1);
    }

    @Test
    public void testFindById() {
        assertSame(machineService.findById(machine1.getId()), machine1);
        verify(machineDao).findById(machine1.getId());
    }


    @Test
    public void findAll() {
        machineService.findAllMachines();
        verify(machineDao).findAll();
    }


}
