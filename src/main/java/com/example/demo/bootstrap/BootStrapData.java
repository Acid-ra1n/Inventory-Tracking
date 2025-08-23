package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Product;
import com.example.demo.repositories.InhousePartRepository;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;
    private final InhousePartRepository inhousePartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository, InhousePartRepository inhousePartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
        this.inhousePartRepository=inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (outsourcedPartRepository.count() == 0) {

            OutsourcedPart o1 = new OutsourcedPart();
            o1.setCompanyName("Samsung");
            o1.setName("CPU");
            o1.setInv(5);
            o1.setMinInv(1);
            o1.setMaxInv(50);
            o1.setPrice(120.0);
            o1.setId(100);
            outsourcedPartRepository.save(o1);
            OutsourcedPart thePart = null;
            List<OutsourcedPart> outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                if (part.getName().equals("CPU")) thePart = part;
            }
            System.out.println(thePart.getCompanyName());

            OutsourcedPart o2 = new OutsourcedPart();
            o2.setCompanyName("Wistron");
            o2.setName("Motherboard");
            o2.setInv(7);
            o2.setMinInv(1);
            o2.setMaxInv(50);
            o2.setPrice(70.0);
            o2.setId(102);
            outsourcedPartRepository.save(o2);
            thePart = null;
            outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                if (part.getName().equals("Motherboard")) thePart = part;
            }
            System.out.println(thePart.getCompanyName());

            OutsourcedPart o3 = new OutsourcedPart();
            o3.setCompanyName("TSMC");
            o3.setName("GPU");
            o3.setInv(10);
            o3.setMinInv(1);
            o3.setMaxInv(50);
            o3.setPrice(200.0);
            o3.setId(104);
            outsourcedPartRepository.save(o3);
            thePart = null;
            outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                if (part.getName().equals("GPU")) thePart = part;
            }
            System.out.println(thePart.getCompanyName());

            outsourcedParts = (List<OutsourcedPart>) outsourcedPartRepository.findAll();
            for (OutsourcedPart part : outsourcedParts) {
                System.out.println(part.getName() + " " + part.getCompanyName());
            }
        }

        if (inhousePartRepository.count() == 0) {

            InhousePart i1 = new InhousePart();
            i1.setName("Heatsink");
            i1.setInv(10);
            i1.setMinInv(1);
            i1.setMaxInv(50);
            i1.setPrice(25.0);
            i1.setId(200);
            inhousePartRepository.save(i1);
            InhousePart thePart = null;
            List<InhousePart> inhouseParts = (List<InhousePart>) inhousePartRepository.findAll();
            for (InhousePart part : inhouseParts) {
                if (part.getName().equals("Heatsink")) thePart = part;
            }

            InhousePart i2 = new InhousePart();
            i2.setName("Case");
            i2.setInv(6);
            i2.setMinInv(1);
            i2.setMaxInv(50);
            i2.setPrice(50.0);
            i2.setId(202);
            inhousePartRepository.save(i2);
            thePart = null;
            inhouseParts = (List<InhousePart>) inhousePartRepository.findAll();
            for (InhousePart part : inhouseParts) {
                if (part.getName().equals("Case")) thePart = part;
            }

            inhouseParts = (List<InhousePart>) inhousePartRepository.findAll();
            for (InhousePart part : inhouseParts) {
                System.out.println(part.getName() + " " + part.getId());
            }
        }

        if (productRepository.count() == 0) {

            Product office_pc= new Product("Office PC",380.0,15);
            productRepository.save(office_pc);
            Product gaming_pc= new Product("Gaming PC",800.0,6);
            productRepository.save(gaming_pc);
            Product workstation= new Product("Workstation",1500.0,7);
            productRepository.save(workstation);
            Product student_pc= new Product("Student PC",350.0,10);
            productRepository.save(student_pc);
            Product streaming_pc= new Product("Streaming PC",500.0,4);
            productRepository.save(streaming_pc);

        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products"+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts"+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
