package kz.bitlab.G118SpringDataJpa.service;

import java.util.List;
import kz.bitlab.G118SpringDataJpa.model.Developer;
import kz.bitlab.G118SpringDataJpa.repository.DeveloperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeveloperService {

  @Autowired
  private DeveloperRepository developerRepository;

  public List<Developer> search(String search) {
    return developerRepository.findAllByText(search);
  }
}
