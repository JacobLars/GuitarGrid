import { Product } from "@/app/types/Types";
import { useParams } from "next/navigation";
import React, { useEffect, useState } from "react";
import { ProductCard } from "./ProductCard";
import { Link } from "@nextui-org/react";
import { SearchBar } from "../searchbar/SearchBar";
type Props = {
  products: Product[];
};
export const ProductGallery = ({ products }: Props) => {
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
      {filteredProducts.map((product, index) => (
        <Link
          key={index}
          href={`/products/${product.category}/product/${product.id}`}
        >
          <ProductCard product={product} />
        </Link>
      ))}
    </div>
  );
};
