package br.com.codethebasics.telepathic.bot.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {

    private final MenuRepository menuRepository;

    @Autowired
    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public List<Menu> list() {
        return this.menuRepository.findAll();
    }

    public Menu findById(Integer id) {
        return this.menuRepository.findById(id).get();
    }

    public Menu save(Menu menu) {
        return this.menuRepository.save(menu);
    }

    public Menu deleteById(Integer id) {
        Menu menu = findById(id);
        if (menu != null) {
            this.menuRepository.deleteById(id);
        }
        return menu;
    }
}
