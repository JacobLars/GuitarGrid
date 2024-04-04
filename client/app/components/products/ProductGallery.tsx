import { Product } from "@/app/types/Types";
import React, { useState } from "react";
import { ProductCard } from "./ProductCard";
import { Link } from "@nextui-org/react";
import { SearchBar } from "../filtering/SearchBar";
import { FilterMenu } from "../filtering/FilterMenu";
import { capitalizeFirstLetter } from "@/app/utils/Utils";
import { AddToCart } from "./AddToCart";
type Props = {
  products: Product[];
  isLoading: boolean;
  guitarType?: string;
  category: string;
  brandName?: string;
};
export const ProductGallery = ({
  products,
  isLoading,
  category,
  brandName,
  guitarType,
}: Props) => {
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
      <div className="text-2xl flex flex-row underline mt-4">
        <h1 className="mx-auto">
          {capitalizeFirstLetter(brandName)} {capitalizeFirstLetter(guitarType)}{" "}
          {capitalizeFirstLetter(category)}{" "}
        </h1>
      </div>
      <SearchBar searchTerm={searchTerm} setSearchTerm={setSearchTerm} />
      <div className="md:flex md:flex-row">
        <section className="md:w-1/4 md:-ml-60">
          <FilterMenu
            products={products}
            setSelectedRatings={setSelectedRatings}
            selectedRatings={selectedRatings}
            setOption={setOption}
          />
        </section>

        <section className="lg:grid lg:grid-cols-2 lg:gap-0 mx-auto md:w-2/3">
          {isLoading ? (
            <img className="h-20 mx-auto my-40" src="/loading.gif" />
          ) : (
            filteredProducts.map((product, index) => (
              <div className="md:flex md:w-full" key={index}>
                <Link
                  href={`/products/${product.category}/product/${product.id}`}
                  className="w-full"
                >
                  <ProductCard product={product} />
                </Link>
                <div className="hidden lg:block md:w-1/4 md:-ml-36 md:mt-20 md:h-10 md:z-10">
                  <AddToCart product={product} />
                </div>
              </div>
            ))
          )}
        </section>
      </div>
    </div>
  );
};
