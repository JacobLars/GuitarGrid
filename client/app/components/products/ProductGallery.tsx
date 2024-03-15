import { Product } from "@/app/types/Types";
import React, { useState } from "react";
import { ProductCard } from "./ProductCard";
import { Link } from "@nextui-org/react";
import { SearchBar } from "../filtering/SearchBar";
import { FilterByRating } from "../filtering/FilterByRating";
import { FilterMenu } from "../filtering/FilterMenu";
type Props = {
  products: Product[];
  isLoading: boolean;
};
export const ProductGallery = ({ products, isLoading }: Props) => {
  const [searchTerm, setSearchTerm] = useState<string>("");
  const [selectedRatings, setSelectedRatings] = useState<number[]>([]);
  const applyFilters = (
    products: Product[],
    term: string,
    ratings: number[]
  ) => {
    let filtered = products.filter(
      (product) =>
        product.category.toLowerCase().includes(term.toLowerCase()) ||
        product.brandName.toLowerCase().includes(term.toLowerCase()) ||
        product.name.toLowerCase().includes(term.toLowerCase())
    );

    if (ratings.length > 0) {
      filtered = filtered.filter((product) => ratings.includes(product.rating));
    }

    return filtered;
  };

  const filteredProducts = applyFilters(products, searchTerm, selectedRatings);

  return (
    <div>
      <SearchBar searchTerm={searchTerm} setSearchTerm={setSearchTerm} />
      <FilterMenu
        products={products}
        setSelectedRatings={setSelectedRatings}
        selectedRatings={selectedRatings}
      />
      {/*       <FilterByRating
        products={products}
        setSelectedRatings={setSelectedRatings}
        selectedRatings={selectedRatings}
      /> */}
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
