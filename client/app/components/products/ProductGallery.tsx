import { Product } from "@/app/types/Types";
import React, { useState } from "react";
import { ProductCard } from "./ProductCard";
import { Link } from "@nextui-org/react";
import { SearchBar } from "../searchbar/SearchBar";
type Props = {
  products: Product[];
  isLoading: boolean;
};
export const ProductGallery = ({ products, isLoading }: Props) => {
  const [searchTerm, setSearchTerm] = useState<string>("");
  const filteredProducts = products.filter(
    (product) =>
      product.category.toLowerCase().includes(searchTerm.toLowerCase()) ||
      product.brandName.toLowerCase().includes(searchTerm.toLowerCase()) ||
      product.name.toLowerCase().includes(searchTerm.toLowerCase())
  );
  return (
    <div>
      <SearchBar searchTerm={searchTerm} setSearchTerm={setSearchTerm} />
      {isLoading ? (
        <img className="h-20 mx-auto my-40" src="/loading.gif" />
      ) : (
        filteredProducts.map((product, index) => (
          <Link
            key={index}
            href={`/products/${product.category}/product/${product.id}`}
          >
            <ProductCard product={product} />
          </Link>
        ))
      )}
    </div>
  );
};
