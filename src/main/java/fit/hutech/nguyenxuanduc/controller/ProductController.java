package fit.hutech.nguyenxuanduc.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping ;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;
import fit.hutech.nguyenxuanduc.Service.ProductService;
import fit.hutech.nguyenxuanduc.models.Product;
import jakarta.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;
	@GetMapping("/create")
	public String create (Model model)
	{
		model.addAttribute("product", new Product());
		return "products/create";
	}
	
	@PostMapping("/create")
	public String create (@Valid Product newProduct,
			BindingResult result,
			Model model) {
		
		if(result.hasErrors())
		{
			model.addAttribute("product", newProduct);
			return "products/create";
		}
		productService.add(newProduct);
		return"redirect:/products";
		
	}
	@GetMapping
	public String index(Model model)
	{
		model.addAttribute("listproduct", productService.GetAll());
		return"products/index";
	}
}

	

