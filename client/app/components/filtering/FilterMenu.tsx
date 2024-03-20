import React, { useState } from "react";
import { FilterByRating } from "./FilterByRating";
import { Product } from "@/app/types/Types";
import { SortByPrice } from "./SortByPrice";
type Props = {
  products: Product[];
  setSelectedRatings: Function;
  selectedRatings: number[];
  setOption: Function;
};
export const FilterMenu = ({
  products,
  setSelectedRatings,
  selectedRatings,
  setOption,
}: Props) => {
  const [isOpen, setIsOpen] = useState<boolean>(false);
  const [icon, setIcon] = useState<string>("/filter.png");
  const handleToggle = () => {
    setIsOpen(!isOpen);
    if (isOpen) {
      setIcon("/filter.png");
    } else {
      setIcon("/close.png");
    }
  };
  return (
    <div className="mt-5 mb-16">
      <img
        className="h-8 absolute mt-2 ml-14 z-10 hover:cursor-pointer hover:bg-slate-100 md:left-1/4 md:hidden"
        src={icon}
        onClick={handleToggle}
      />
      <div
        className={`mx-auto w-3/4 transition-transform ease-out duration-300 md:w-1/3 md:border md:border-slate-600 md:rounded-md md:shadow-md ${
          isOpen
            ? "translate-x-0 border border-slate-600 rounded-md shadow-md"
            : "translate-x-full"
        }`}
      >
        {/* Always render FilterByRating and SortByPrice */}
        <FilterByRating
          products={products}
          setSelectedRatings={setSelectedRatings}
          selectedRatings={selectedRatings}
        />
        <SortByPrice setOption={setOption} />
      </div>
    </div>
  );
};
