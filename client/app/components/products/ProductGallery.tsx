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
  const [option, setOption] = useState<string>("");
  const applyFilters = (
    products: Product[],
    term: string,
    ratings: number[],
    option: string
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

    if (option === "Highest to lowest") {
      filtered = filtered.sort((p1, p2) => p2.price - p1.price);
    }

    if (option === "Lowest to highest") {
      filtered = filtered.sort((p1, p2) => p1.price - p2.price);
    }

    return filtered;
  };

  const filteredProducts = applyFilters(
    products,
    searchTerm,
    selectedRatings,
    option
  );

  return (
    <div>
      <SearchBar searchTerm={searchTerm} setSearchTerm={setSearchTerm} />
      <FilterMenu
        products={products}
        setSelectedRatings={setSelectedRatings}
        selectedRatings={selectedRatings}
        setOption={setOption}
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
