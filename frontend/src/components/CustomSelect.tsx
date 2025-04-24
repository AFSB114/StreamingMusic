import { CustomSelectProps } from "@/types";
import { ChangeEvent, useEffect, useRef, useState } from "react";
import { ChevronDown, ChevronUp } from "lucide-react";

export default function CustomSelect<T>({
  name,
  label,
  options,
  value,
  onChange,
  optionLabelKey,
  optionValueKey,
  placeholder = "Select an option",
  maxHeight = "200px",
  required = false,
  variant = "down",
}: CustomSelectProps<T>) {
  const [isOpen, setIsOpen] = useState(false);
  const ref = useRef<HTMLDivElement>(null);

  const toggleOpen = () => setIsOpen((prev) => !prev);
  const close = () => setIsOpen(false);

  const selectedOption = options.find(
    (opt) => String(opt[optionValueKey]) === value
  );

  useEffect(() => {
    const handleClickOutside = (e: MouseEvent) => {
      if (ref.current && !ref.current.contains(e.target as Node)) {
        close();
      }
    };

    document.addEventListener("mousedown", handleClickOutside);
    return () => document.removeEventListener("mousedown", handleClickOutside);
  }, []);

  return (
    <div className="relative w-full" ref={ref}>
      <label className="block mb-1">{label}</label>

      <div
        onClick={toggleOpen}
        className="p-2 bg-zinc-800 border border-zinc-700 rounded cursor-pointer flex justify-between items-center"
      >
        <span className="truncate">
          {selectedOption
            ? String(selectedOption[optionLabelKey])
            : placeholder}
        </span>
        {variant === "up" ? (
          <ChevronUp
            className={`w-4 h-4 transform transition-transform ${
              isOpen ? "rotate-180" : ""
            }`}
          />
        ) : (
          <ChevronDown
            className={`w-4 h-4 transform transition-transform ${
              isOpen ? "rotate-180" : ""
            }`}
          />
        )}
      </div>

      <div
        className={`
          absolute z-10 mt-1 w-full bg-zinc-800 border border-zinc-700 rounded shadow-lg overflow-y-auto
          transition-all duration-150 origin-top transform ${
            variant === "up" ? "bottom-[65%]" : ""
          }
          ${
            isOpen
              ? "scale-100 opacity-100 pointer-events-auto"
              : "scale-95 opacity-0 pointer-events-none"
          }
        `}
        style={{ maxHeight }}
      >
        {options.map((option) => (
          <div
            key={String(option[optionValueKey])}
            onClick={() => {
              const syntheticEvent = {
                target: {
                  name,
                  value: String(option[optionValueKey]),
                },
              } as ChangeEvent<HTMLInputElement>;
              onChange(syntheticEvent);
              close();
            }}
            className="px-3 py-2 hover:bg-red-900 cursor-pointer truncate"
          >
            {String(option[optionLabelKey])}
          </div>
        ))}
      </div>

      <input
        type="hidden"
        name={name}
        value={value}
        onChange={onChange}
        required={required}
      />
    </div>
  );
}
