package com.simplishop.item;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ItemConfig {
    @Bean
    CommandLineRunner commandLineRunnerItem(
            ItemRepository itemRepository) {
        return args -> {
            Item item1 = new Item(
                    "Game Boy",
                    "https://upload.wikimedia.org/wikipedia/commons/f/f4/Game-Boy-FL.jpg",
                    "1990s games console from Nintendo",
                    "Technology",
                    5,
                    20.00
            );
            Item item2 = new Item(
                    "Phone",
                    "https://www.three.co.uk/cs/Satellite?blobkey=id&blobwhere=1401331509853&blobcol=urldata&blobtable=MungoBlobs",
                    " The new high quality iPhone 13 with the latest Apple technology.",
                    "Technology",
                    1,
                    199.99

            );
            Item item3 = new Item(
                    "Camera",
                    "https://media.currys.biz/i/currysprod/M10205274_white?$l-large$&fmt=auto",
                    "A vintage polaroid camera that can prints out photos instantly.",
                    "Technology",
                    5,
                    800.00
            );
            Item item4 = new Item(
                    "Portable Speaker",
                    "https://m.media-amazon.com/images/I/810dSwE0MoL._AC_SL1500_.jpg",
                    "A portable Bluetooth speaker with excellent sound quality",
                    "Technology",
                    15,
                    50.00
            );
            Item item5 = new Item(
                    "Laptop",
                    "https://m.media-amazon.com/images/I/711jgF2LHPL._AC_SY450_.jpg",
                    "A high-performance laptop with a sleek design and powerful processor",
                    "Technology",
                    10,
                    1000.00
            );
            Item item6 = new Item(
                    "Area Rug",
                    "https://m.media-amazon.com/images/I/81Ru4Az6E2L._AC_SL1500_.jpg",
                    "A colorful and stylish area rug made of high-quality wool",
                    "Home",
                    8,
                    150.00
            );
            Item item7 = new Item(
                    "Office Chair",
                    "https://www.ikea.com/gb/en/images/products/flintan-office-chair-with-armrests-black__1007241_pe825960_s5.jpg",
                    "An ergonomic office chair with adjustable lumbar support",
                    "Home",
                    10,
                    150.00
            );
            Item item8 = new Item(
                    "Bookshelf",
                    "https://www.therange.co.uk/_m3/8/2/1465382547_829.jpg",
                    "A sturdy bookshelf made of solid wood",
                    "Home",
                    5,
                    150.00
            );
            Item item9 = new Item(
                    "Bedding Set",
                    "https://asset1.cxnmarksandspencer.com/is/image/mands/MS_05_T35_2052B_ZZ_X_EC_0?$Intl_PDP_Tab$",
                    "A luxurious bedding set with a comforter, sheets, and pillowcases",
                    "Home",
                    10,
                    200.00
            );
            Item item10 = new Item(
                    "Painting",
                    "https://as1.ftcdn.net/v2/jpg/02/73/22/74/1000_F_273227473_N0WRQuX3uZCJJxlHKYZF44uaJAkh2xLG.jpg",
                    "A beautiful landscape painting by a local artist",
                    "Home",
                    3,
                    200.00
            );
            Item item11 = new Item(
                    "Sneakers",
                    "https://www.chloe.com/product_image/11596937jh/f/w1080.jpg",
                    "A pair of comfortable and stylish sneakers",
                    "Fashion",
                    20,
                    75.00
            );
            Item item12 = new Item(
                    "Women's Coat",
                    "https://outdoorgearlab-mvnab3pwrvp3t0.stackpathdns.com/photos/23/66/358121_9734_XXL.jpg",
                    "A warm and stylish coat with a wool blend outer and a faux fur trim",
                    "Fashion",
                    5,
                    150.00
            );
            Item item13 = new Item(
                    "Men's Dress Shirt",
                    "https://media.gq.com/photos/5d0910a73e9be8341b43701d/master/w_2000,h_1333,c_limit/Tommy-Hilfgier-slim-fit-no-iron-dress-shirt.jpg",
                    "A high-quality dress shirt with a slim fit and wrinkle-resistant fabric",
                    "Fashion",
                    10,
                    50.00
            );
            Item item14 = new Item(
                    "Women's Sunglasses",
                    "https://avvenice.com/89935-home_default/no-logo-eyewear-nol19008-sun-blue-and-grey-sunglasses.jpg",
                    "A pair of trendy and UV-protected sunglasses with a polarized lens",
                    "Fashion",
                    15,
                    25.00
            );
            Item item15 = new Item(
                    "Men's Wallet",
                    "https://www.formfonts.com/files/1/12343/leather-mens-wallet-folded_FF_Model_ID12343_1_MWT10_00.jpg",
                    "A leather wallet with multiple card slots and a coin pocket",
                    "Fashion",
                    8,
                    30.00);
            Item item16 = new Item(
                    "Scooter",
                    "https://www.laptopsdirect.co.uk/Images/E-SC10-V1_1_Supersize.jpg?v=61",
                    "electric scooter",
                    "Toys",
                    5,
                    12.99
            );
            Item item17 = new Item(
                    "Dollhouse",
                    "https://www.petiteamelie.co.uk/media/catalog/product/cache/11/thumbnail/1024x/85e4522595efc69f496374d01ef2bf13/n/a/natural-wooden-dolls-house-victorian-petite-amelie.jpg",
                    "A beautifully detailed dollhouse with furniture and miniature accessories",
                    "Toys",
                    3,
                    100.00
            );
            Item item18 = new Item(
                    "Building Set",
                    "https://www.learningresources.co.uk/media/catalog/product/l/e/ler2843_main.jpg?quality=80&bg-color=255,255,255&fit=bounds&height=500&width=700&canvas=700:500",
                    "A building set with a variety of colorful and interlocking blocks",
                    "Toys",
                    8,
                    15.00
            );
            Item item19 = new Item(
                    "Plush Toy",
                    "https://images.stockx.com/images/Pokemon-x-Thunderbolt-Project-by-Fragment-Pikachu-Plush-Yellow.jpg?fit=fill&bg=FFFFFF&w=1200&h=857&fm=webp&auto=compress&dpr=2&trim=color&updated_at=1610576652&q=75",
                    "A soft and cuddly plush toy in the shape of a popular character",
                    "Toys",
                    15,
                    10.00
            );
            Item item20 = new Item(
                    "Remote Control Car",
                    "https://media.product.which.co.uk/prod/images/original/8fc5fab7470e-modelsport-blackzon-slyder-mt-monster-truck.jpg",
                    "A remote control car with a high-speed motor and off-road capabilities",
                    "Toys",
                    5,
                    50.00);
            Item item21 = new Item(
                    "Pride and Prejudice",
                    "https://almabooks.com/wp-content/uploads/2016/10/9781847493699.jpg",
                    "A classic novel by Jane Austen about the societal pressures faced by the Bennett sisters",
                    "Books",
                    15,
                    10.00
            );
            Item item22 = new Item(
                    "Mastering the Art of French Cooking",
                    "https://i.etsystatic.com/26596358/r/il/5b6e50/3737669585/il_fullxfull.3737669585_71k8.jpg",
                    "A cookbook by Julia Child, Louisette Bertholle, and Simone Beck with classic French recipes",
                    "Books",
                    10,
                    20.00
            );
            Item item23 = new Item(
                    "The 7 Habits of Highly Effective People",
                    "https://m.media-amazon.com/images/I/81+zleD0DUL.jpg",
                    "A self-help book by Stephen R. Covey on developing personal and interpersonal effectiveness",
                    "Books",
                    5,
                    15.00
            );
            Item item24 = new Item(
                    "Where the Wild Things Are",
                    "https://m.media-amazon.com/images/I/81A0QfNNutL.jpg",
                    "A children's picture book by Maurice Sendak about a young boy's adventures in a forest of mythical creatures",
                    "Books",
                    8,
                    10.00
            );
            Item item25 = new Item(
                    "Introduction to the Theory of Computation",
                    "https://m.media-amazon.com/images/I/515u8TZAIlL._SX344_BO1,204,203,200_.jpg",
                    "A textbook by Michael Sipser on the fundamental principles of computer science",
                    "Books",
                    3,
                    50.00
            );
            Item item26 = new Item(
                    "Hose Reel",
                    "https://brodexbms.co.uk/wp-content/uploads/Van-Mounted-Hose-Reel-2.jpg",
                    "This hose reel is made of durable plastic and includes a built-in hose guide to help prevent tangles. It holds up to 50 feet of hose.",
                    "Garden",
                    5,
                    19.99
            );
            Item item27 = new Item(
                    "Leather Gardening Gloves",
                    "https://www.webury.com/media/catalog/product/cache/a11b6893555e7d42fa4f67cf12d2e8dc/w/e/web029_briers_gardening_gloves_golden_leather_b6423.jpg",
                    "These leather gardening gloves are durable and comfortable to wear, with a secure fit and good grip. They are perfect for protecting your hands while working in the garden.",
                    "Garden",
                    3,
                    9.99
            );
            Item item28 = new Item(
                    "Terra Cotta Plant Pots",
                    "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTu8wFi6kktL_03Gb-q2mFNcAlIYmmiDSng_LphRuwtIwUcyB98IfrhFNeIMo9lNemAyVQ&usqp=CAU",
                    "These terra cotta plant pots are classic and timeless, perfect for any garden. They are made of clay and have a natural, rustic look.",
                    "Garden",
                    4,
                    3.49
            );
            Item item29 = new Item(
                    "Heirloom Vegetable Seeds",
                    "https://cdn.shopify.com/s/files/1/0679/7951/products/Sow-Heritage-Pack-60_grande.jpg?v=1629556713",
                    "These heirloom vegetable seeds are non-GMO and grown using organic methods. The collection includes a variety of popular vegetables such as tomatoes, peppers, and squash.",
                    "Garden",
                    1,
                    9.99
            );
            Item item30 = new Item(
                    "Organic Plant Fertilizer",
                    "https://www.lovethegarden.com/sites/default/files/styles/product_xl/public/content/products/UK_119912_MG_PS.png.jpg?itok=tIuCps8-",
                    "This organic plant fertilizer is made from natural ingredients and is safe for use on all types of plants. It helps to promote healthy growth and strong roots.",
                    "Garden",
                    2,
                    14.99
            );
            Item item31 = new Item(
                    "Huggies Snug & Dry Diapers",
                    "https://assets.shop.loblaws.ca/products/21238553/b1/en/front/21238553_front_a01_@2.png",
                    "These Huggies diapers are designed to keep your baby dry and comfortable. They have a absorbent core and a secure fit to prevent leaks.",
                    "Baby",
                    6,
                    34.99
            );
            Item item32 = new Item(
                    "Pampers Sensitive Baby Wipes",
                    "https://groceries.morrisons.com/productImages/501/501393011_0_640x640.jpg?identifier=e6ffa68eb2e5ea36838de202845d4abd",
                    "These Pampers baby wipes are gentle and hypoallergenic, making them safe to use on your baby's delicate skin. They are also alcohol-free and pH balanced.",
                    "Baby",
                    12,
                    19.99
            );
            Item item33 = new Item(
                    "Similac Advance Infant Formula",
                    "https://m.media-amazon.com/images/I/61KCdz1wVuL._AC_SL1300_.jpg",
                    "This Similac infant formula is designed to support your baby's growth and development. It is easy to digest and contains essential nutrients like iron and DHA.",
                    "Baby",
                    2,
                    49.99
            );
            Item item34 = new Item(
                    "Cotton Onesies",
                    "https://media.vertbaudet.co.uk/Pictures/vertbaudet/173746/pack-of-5-long-sleeve-bodysuits-in-pure-cotton-for-babies.jpg",
                    "These soft and comfortable cotton onesies are perfect for your baby's delicate skin. They come in a variety of colors and sizes.",
                    "Baby",
                    6,
                    24.99
            );
            Item item35 = new Item(
                    "Graco Modes Click Connect Travel System",
                    "https://i5.walmartimages.com/asr/599d7cfb-0c85-45e1-b61d-f878a4fe1a0a_1.16bf0c0bce614b19b7937d4f56c835ac.jpeg?odnHeight=612&odnWidth=612&odnBg=FFFFFF",
                    "This Graco stroller is a versatile and convenient travel system that includes a stroller, car seat, and base. It has a one-hand fold and a multi-position reclining seat for your baby's comfort.",
                    "Baby",
                    1,
                    199.99
            );




            itemRepository.saveAll(
                    List.of(item1, item2, item3, item4, item5, item6,item7, item8, item9, item10, item11, item12, item13, item14,item15, item16, item17, item18, item19, item20,item21, item22, item23, item24, item25, item26, item27, item28, item29, item30,item31, item32, item33, item34, item35));
        };
    }
}
